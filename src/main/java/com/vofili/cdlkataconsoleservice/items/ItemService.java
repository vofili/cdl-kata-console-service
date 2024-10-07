package com.vofili.cdlkataconsoleservice.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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


    public void printPricingRules(){
        for(Map.Entry<String,Item> entry:pricingRule.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue().toString());
        }
    }

    public void clearPricingRules(){
        pricingRule.clear();
    }
    //define default pricing rules by adding items, special offer prices and special offer qty
    @Bean
    public Map<String,Item> initDefaultPriceRule(){
        Item itemA = new Item("A",50,null);
        Item itemB = new Item("B",30,null);
        Item itemC = new Item("C",20,null);
        Item itemD = new Item("D",15,null);
        pricingRule.put("A",itemA);
        pricingRule.put("B",itemB);
        pricingRule.put("C",itemC);
        pricingRule.put("D",itemD);
        printPricingRules();
        return pricingRule;
    }



}
