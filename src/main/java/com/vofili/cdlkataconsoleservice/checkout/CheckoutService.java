package com.vofili.cdlkataconsoleservice.checkout;


import com.vofili.cdlkataconsoleservice.items.Item;
import com.vofili.cdlkataconsoleservice.items.ItemOffer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckoutService {

    Map<String,Item> pricingRule;
    private int runningTotal=0;
    Map<String, Integer> scanItems = new HashMap<String,Integer>();

   public void scanItem(String sku){
       scanItems.put(sku,scanItems.getOrDefault(sku,0)+1);
   }

   public Integer getRunningTotal(){
       runningTotal = 0;
       for(Map.Entry<String,Integer>entry : scanItems.entrySet()){
            String sku=entry.getKey();
            Integer qty = entry.getValue();
            runningTotal += calculateCheckoutPrice(sku,qty);
       }

       return runningTotal;
   }


   public Integer calculateCheckoutPrice(String sku,int quantity){
       ItemOffer itemOffer = pricingRule.get(sku).getItemOffer();
           if(itemOffer != null){
               int discountItems = quantity / itemOffer.getQuantity();
               int remainingItems = quantity % itemOffer.getQuantity();
                return (discountItems * itemOffer.getPrice()) + (remainingItems * pricingRule.get(sku).getUnitPrice());
           }else{
                return pricingRule.get(sku).getUnitPrice() * quantity;
           }

   }

   public void clearCheckout()
   {
       scanItems.clear();
   }

}