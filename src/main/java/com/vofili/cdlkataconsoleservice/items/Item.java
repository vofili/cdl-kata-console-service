package com.vofili.cdlkataconsoleservice.items;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Item {
    Long id;
    String productName;
    Double unitPrice;
    Character sku;
    Double offerPrice;
    Integer offerCount;


}
