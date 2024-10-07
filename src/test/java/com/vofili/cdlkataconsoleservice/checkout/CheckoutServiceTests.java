package com.vofili.cdlkataconsoleservice.checkout;


import com.vofili.cdlkataconsoleservice.items.Item;
import com.vofili.cdlkataconsoleservice.items.ItemOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class CheckoutServiceTest {

    @InjectMocks
    private CheckoutService checkoutService;

    @Mock
    private Map<String, Item> pricingRule;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pricingRule = new HashMap<>();
        checkoutService = new CheckoutService();
        checkoutService.pricingRule = pricingRule;
    }

    @Test
    void scanItem_ShouldAddItemToScanItems() {
        checkoutService.scanItem("A");
        // Assert
        assertEquals(1, checkoutService.orderItems.get("A"));
    }

    @Test
    void scanItem_ShouldIncrementItemCountIfAlreadyScanned() {

        checkoutService.orderItems.put("A", 1);
        checkoutService.scanItem("A");
        // Assert
        assertEquals(2, checkoutService.orderItems.get("A"));
    }

    @Test
    void getRunningTotal_ShouldReturnCorrectTotalWithoutOffers() {
        Item itemA = new Item("A", 50, null);
        when(pricingRule.get("A")).thenReturn(itemA);
        checkoutService.scanItem("A");
        checkoutService.scanItem("A");
        int total = checkoutService.getRunningTotal();

        assertEquals(100, total);
    }

    @Test
    void getRunningTotal_ShouldReturnCorrectTotalWithOffers() {

        ItemOffer offer = new ItemOffer("A", 130,3);
        Item itemA = new Item("A", 50, offer);
        when(pricingRule.get("A")).thenReturn(itemA);
        checkoutService.scanItem("A");
        checkoutService.scanItem("A");
        checkoutService.scanItem("A");
        int total = checkoutService.getRunningTotal();

        // Assert
        assertEquals(130, total);
    }

    @Test
    void calculateCheckoutPrice_ShouldApplyOfferCorrectly() {
        ItemOffer offer = new ItemOffer("A", 130,3);
        Item itemA = new Item("A", 50, offer);
        when(pricingRule.get("A")).thenReturn(itemA);
        int totalPrice = checkoutService.calculateCheckoutPrice("A", 3);
        // Assert
        assertEquals(130, totalPrice);
    }

    @Test
    void calculateCheckoutPrice_ShouldHandleItemsWithoutOffer() {
        Item itemB = new Item("B", 30, null);
        when(pricingRule.get("B")).thenReturn(itemB);
        int totalPrice = checkoutService.calculateCheckoutPrice("B", 2);
        assertEquals(60, totalPrice);
    }

    @Test
    void clearCheckout_ShouldClearScannedItems() {
        checkoutService.scanItem("A");
        checkoutService.clearCheckout();
        assertTrue(checkoutService.orderItems.isEmpty());
    }
}
