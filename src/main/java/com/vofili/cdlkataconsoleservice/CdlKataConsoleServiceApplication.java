package com.vofili.cdlkataconsoleservice;

import com.vofili.cdlkataconsoleservice.items.ItemService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import java.util.Scanner;
import java.util.logging.Logger;
@Slf4j
@SpringBootApplication
public class CdlKataConsoleServiceApplication implements CommandLineRunner {

    @Autowired
    ItemService itemService;

    public static void main(String[] args) {

        SpringApplication.run(CdlKataConsoleServiceApplication.class, args);

    }

//    @PostConstruct
//    public void init(){
//        itemService.initDefaultPriceRule();
//    }


    public void run(String... args){

//            for(var item : args){
//                log.info("args ",item);
//            }
            Scanner scanner = new Scanner(System.in);
            String opt;

        while(true) {


            System.out.println("Enter an option to choose an operation:\n (D)efine pricing rule \n (S)can an item \n (C)heckout \n (E)nd the program \n");
            opt = scanner.next();
            System.out.println("Item entered " + opt);

            switch (opt.toUpperCase()) {
                case "D":
                    System.out.println("Define a pricing rule");

                    break;
                case "S":
                    System.out.println("Scan an item");
                    break;
                case "C":
                    System.out.println("Checkout an item");
                    break;
                default:
                    System.out.println("End the checkout");
                    System.exit(0);

            }


        }


    }
}
