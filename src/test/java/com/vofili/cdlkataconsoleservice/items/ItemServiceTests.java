package com.vofili.cdlkataconsoleservice.items;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private Map<String, Item> pricingRule;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pricingRule = new HashMap<>();
        itemService = new ItemService(pricingRule);
    }

    @Test
    void addNewPriceRule_ShouldAddItemToPricingRule() {
        // Arrange
        Item item = new Item("A", 50, null);
        Map<String, Item> expectedPricingRule = new HashMap<>();
        expectedPricingRule.put(item.getSku(), item);

        // Act
        Map<String, Item> result = itemService.addNewPriceRule(item);

        // Assert
        assertEquals(expectedPricingRule, result);
        assertTrue(pricingRule.containsKey("A"));
        assertEquals(item, pricingRule.get("A"));
    }

    @Test
    void printPricingRules_ShouldPrintAllPricingRules() {
        // Setup
        Item itemA = new Item("A", 50, null);
        pricingRule.put("A", itemA);
        Item itemB = new Item("B", 30, null);
        pricingRule.put("B", itemB);

        // action
        itemService.printPricingRules();
    }

    @Test
    void clearPricingRules_ShouldClearAllPricingRules() {
        // Setup
        Item itemA = new Item("A", 50, null);
        pricingRule.put("A", itemA);
        assertFalse(pricingRule.isEmpty());

        // action
        itemService.clearPricingRules();

        // Assert
        assertTrue(pricingRule.isEmpty());
    }

    @Test
    void initDefaultPriceRule_ShouldInitializeDefaultItems() {

        Map<String, Item> result = itemService.initDefaultPriceRule();

        // Assert
        assertNotNull(result);
        assertEquals(4, result.size());
        assertTrue(result.containsKey("A"));
        assertTrue(result.containsKey("B"));
        assertTrue(result.containsKey("C"));
        assertTrue(result.containsKey("D"));

        // Check initialized items
        assertEquals(50, result.get("A").getUnitPrice());
        assertEquals(30, result.get("B").getUnitPrice());
        assertEquals(20, result.get("C").getUnitPrice());
        assertEquals(15, result.get("D").getUnitPrice());
    }
}
