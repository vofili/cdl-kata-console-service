package com.vofili.cdlkataconsoleservice.orders;

import lombok.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Order {

    Long id;
    HashMap<String,OrderItem> orderItem;
    Double orderTotal;

}
