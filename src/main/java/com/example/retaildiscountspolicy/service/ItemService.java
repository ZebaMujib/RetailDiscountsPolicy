package com.example.retaildiscountspolicy.service;

import com.example.retaildiscountspolicy.Enum.ItemEnum;
import com.example.retaildiscountspolicy.model.Item;

public class ItemService extends Item {

    public ItemService(String name, double unitPrice, ItemEnum itemType) {
        super(name, unitPrice, itemType);
    }

    double totalPriceForQuantity(int quantity) {
        return getUnitPrice() * (double) quantity;
    }
}