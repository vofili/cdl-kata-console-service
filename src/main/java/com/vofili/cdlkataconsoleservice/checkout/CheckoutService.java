package com.vofili.cdlkataconsoleservice.checkout;


import com.vofili.cdlkataconsoleservice.items.Item;
import com.vofili.cdlkataconsoleservice.items.ItemOffer;
import com.vofili.cdlkataconsoleservice.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckoutService {

    @Autowired
    ItemService itemService;

    Map<String,Item> pricingRule;

    private int runningTotal=0;
    Map<String, Integer> orderItems = new HashMap<String,Integer>();

   public void scanItem(String sku){
       orderItems.put(sku,orderItems.getOrDefault(sku,0)+1);
        runningTotal= getRunningTotal();
       // Display running total after each item is scanned
       System.out.println("Running total after adding item:" + sku +" is: " +runningTotal + " pence" + " £"+  runningTotal/100.0+"\n");
   }


   public Integer getRunningTotal(){

       runningTotal = orderItems.entrySet().stream()
               .mapToInt(entry -> calculateCheckoutPrice(entry.getKey(), entry.getValue()))
               .sum();
       return runningTotal;
   }




    //calculate the checkout price based on the quantity of each sku and any available offers
   public Integer calculateCheckoutPrice(String sku,int quantity){
       pricingRule = itemService.getPricingRule();
      Item item = pricingRule.get(sku);
       ItemOffer itemOffer = pricingRule.get(sku).getItemOffer();
           if(itemOffer != null){
               int discountItems = quantity / itemOffer.getQuantity();
               int remainingItems = quantity % itemOffer.getQuantity();
                return (discountItems * itemOffer.getPrice()) + (remainingItems * item.getUnitPrice());
           }else{
                return item.getUnitPrice() * quantity;
           }
   }

   //reset the order items cart
   public void clearCheckout()
   {
       orderItems.clear();
   }

}