package com.example.retaildiscountspolicy.controller;


import com.example.retaildiscountspolicy.model.Item;
import com.example.retaildiscountspolicy.service.FinalCartService;
import com.example.retaildiscountspolicy.service.ItemService;
import com.example.retaildiscountspolicy.service.NormalDiscountService;
import com.example.retaildiscountspolicy.service.PromotionDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    FinalCartService finalCartService;

    @PostMapping("/cart/{id}/total")
    public ResponseEntity<?> total(@PathVariable("id") long customerId,
                                   @RequestBody Item item) {


        finalCartService.add(item,item.getQuantity());
        Double totalCostToCustomer = finalCartService.total();

        return new ResponseEntity<Double>(totalCostToCustomer, HttpStatus.OK);
    }
}
