package com.example.retaildiscountspolicy.controller;


import com.example.retaildiscountspolicy.Enum.ItemEnum;
import com.example.retaildiscountspolicy.model.Item;
import com.example.retaildiscountspolicy.service.FinalCartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {
        @Mock
        private FinalCartService finalCartService;

        @Test
        void getTotalCostOfItems_ReturnTotalCost() {
            // Arrange
            Item item1 = new Item("RICE",37.50, ItemEnum.GROCERY, 5);
            Item item2 = new Item("Brush", 1.1, ItemEnum.NON_GROCERY, 1);
            finalCartService.add(item1, item1.getQuantity());
            finalCartService.add(item2, item2.getQuantity());
            double response= finalCartService.total();
            ResponseEntity<Double> resp = new ResponseEntity<>(response, HttpStatus.OK);
            // Assert
            assertEquals(HttpStatus.OK, resp.getStatusCode());
            assertEquals(response, resp.getBody());
        }


    @Test
    void getTotalCostOfItems_ReturnTotalCostAsZero() {
        // Arrange
        Item item1 = new Item("",0.0, null, 0);
        Item item2 = new Item("", 0.0, null, 0);
        finalCartService.add(item1, item1.getQuantity());
        finalCartService.add(item2, item2.getQuantity());
        double response= finalCartService.total();
        ResponseEntity<Double> resp = new ResponseEntity<>(response, HttpStatus.OK);
        // Assert
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(0.0, resp.getBody());
    }


}