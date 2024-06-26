package com.example.retaildiscountspolicy.model;

import com.example.retaildiscountspolicy.Enum.ItemEnum;
import lombok.Data;

@Data
public class Item {

    private final String name;
    private final double unitPrice;
    private final ItemEnum itemType;
    private final Integer quantity;


    public Item(String name, double unitPrice, ItemEnum itemType, Integer quantity){
        this.name = name;
        this.unitPrice = unitPrice;
        this.itemType = itemType;
        this.quantity=quantity;
    }

}
