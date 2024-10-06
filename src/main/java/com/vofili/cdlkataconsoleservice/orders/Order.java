package com.vofili.cdlkataconsoleservice.orders;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Data
public class Order {

    Long id;
    LocalDate orderdate;
    List <OrderItem> orderItem;
    Double orderTotal;

}
