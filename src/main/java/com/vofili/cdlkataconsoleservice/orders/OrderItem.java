package com.vofili.cdlkataconsoleservice.orders;


import com.vofili.cdlkataconsoleservice.items.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
    Long id;
    Integer quantity;
    Item item;
    Double price;
}
