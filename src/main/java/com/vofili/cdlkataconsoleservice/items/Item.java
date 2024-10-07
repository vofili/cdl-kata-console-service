package com.vofili.cdlkataconsoleservice.items;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@AllArgsConstructor
public class Item {
    private String sku;
    private int unitPrice;
    private ItemOffer itemOffer;
}
