package com.vofili.cdlkataconsoleservice.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ItemOffer {


    private String sku;
    private Integer price;
    private Integer quantity;



}
