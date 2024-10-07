package com.vofili.cdlkataconsoleservice.orders;

import com.vofili.cdlkataconsoleservice.items.Item;
import com.vofili.cdlkataconsoleservice.items.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    Order order;

    public void addItemToOrder(Item item, Integer quantity) {

    }

    @Bean
    public Order initNewOrder() {
        return new Order();
    }


}


