package com.vofili.cdlkataconsoleservice;

import com.vofili.cdlkataconsoleservice.checkout.CheckoutService;
import com.vofili.cdlkataconsoleservice.items.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CdlKataConsoleServiceApplication implements CommandLineRunner {


    @Autowired
    CheckoutService checkoutService;
    @Autowired
    ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(CdlKataConsoleServiceApplication.class, args);
    }

    @Override
    public void run(String... args){

            Scanner scanner = new Scanner(System.in);
            String input="";
            int total;
            while(!input.equalsIgnoreCase("exit")){
                System.out.println("Welcome to the CDL Kata Checkout System \n Enter an option to Proceed:" +
                        "\n (S)can an item " +
                        "\n (V)iew current Pricing " +
                        "\n (D)efine New Pricing " +
                        "\n (G)et final Total " +
                        "\n (E)xit to close\n");
                input = scanner.next().trim();
                System.out.println("Option entered " + input);

                switch (input.toUpperCase()) {

                    case "S":
                        System.out.println("Enter an item to scan ");
                        itemService.printAllAvailableSKUs();
                        String item = scanner.next();
                        checkoutService.scanItem(item);
                        break;
                    case "V":
                        System.out.println("View current Pricing");
                        itemService.printPricingRules();
                        break;
                    case "D":
                        System.out.println("Define New Pricing");
                        itemService.setPricingRules();
                        break;
                    case "G":
                        System.out.println("Get final total");
                        total = checkoutService.getRunningTotal();
                        checkoutService.clearCheckout();
                        System.out.println("Final total: " +total + " pence " + " £"+total/100);
                        break;
                    default:
                        System.out.println("End the checkout");
                        checkoutService.clearCheckout();
                        System.exit(0);

                }
            }






    }
}
