package com.vofili.cdlkataconsoleservice.orders;


import com.vofili.cdlkataconsoleservice.items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderItem {

    Item item;
    Integer quantity;
    Double price;
}
