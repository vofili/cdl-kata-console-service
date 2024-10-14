package com.vofili.cdlkataconsoleservice.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Service
public class ItemService {

    Map<String,Item> pricingRule;

    // this service defines a method create a new pricing rule
    public Map<String,Item> addNewPriceRule(Item item){
        pricingRule.put(item.getSku(),item);
        return pricingRule;
    }


    //Read in single or multiple pricing rules for new or existing SKU's
    public void setPricingRules()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set pricing rules for the transaction.");
        boolean addMoreItems = true;
        while (addMoreItems) {
            System.out.print("Enter item SKU: ");
            String sku = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter unit price (in pence): ");
            int unitPrice = scanner.nextInt();

            System.out.println("Does " +sku+" have a special Offer ?");
            String discountFlag = scanner.nextLine().trim().toUpperCase();
            if(discountFlag.equalsIgnoreCase("Y")){
                System.out.print("Enter Special Offer quantity: ");
                int offerQuantity = scanner.nextInt();

                System.out.print("Enter Special Offer price: ");
                int offerPrice = scanner.nextInt();
                // Create pricing rule and add to map
                pricingRule.put(sku, new Item(sku, unitPrice, new ItemOffer(sku,offerPrice,offerQuantity)));
                scanner.nextLine();  // Consume newline
            }else{
                // Create pricing rule and add to map
                pricingRule.put(sku, new Item(sku, unitPrice,null));

            }


            System.out.print("Add more items to pricing? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreItems = response.equals("yes");
        }
    }

    public void printPricingRules() {
        pricingRule.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue().toString()));
    }

    public void printAllAvailableSKUs() {
        System.out.println("Available SKUs: ");
        System.out.println(pricingRule.keySet().stream()
                .sorted().collect(Collectors.joining(", "))); // Print each SKU
    }

    public void clearPricingRules(){
        pricingRule.clear();
    }
    //define default pricing rules by adding items, special offer prices and special offer qty
    @Bean
    public Map<String,Item> initDefaultPriceRule(){
        Item itemA = new Item("A",50,new ItemOffer("A",130,3));
        Item itemB = new Item("B",30,new ItemOffer("B",45,2));
        Item itemC = new Item("C",20,null);
        Item itemD = new Item("D",15,null);

        pricingRule.put("A",itemA);
        pricingRule.put("B",itemB);
        pricingRule.put("C",itemC);
        pricingRule.put("D",itemD);

        return pricingRule;
    }



}
