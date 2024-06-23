package com.example.retaildiscountspolicy.service;

import com.example.retaildiscountspolicy.Enum.ItemEnum;
import com.example.retaildiscountspolicy.model.Item;

import static com.example.retaildiscountspolicy.Enum.ItemEnum.GROCERY;
import static com.example.retaildiscountspolicy.Enum.ItemEnum.valueOf;

public class PromotionDiscountService extends ItemService{
    private final double priceFactor;
    private Item item;
    public PromotionDiscountService(Item item, int percentPromotion) {
        super(item.getName(), item.getUnitPrice(), item.getItemType());

        if (percentPromotion >= 0 && percentPromotion <= 100) {
            this.priceFactor = (double)(100 - percentPromotion) / 100.0;
        } else {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }
    }

    public double totalPriceForQuantity(int quantity) {
        return super.getItemType()== ItemEnum.GROCERY ? super.totalPriceForQuantity(quantity) : super.totalPriceForQuantity(quantity) * this.priceFactor;
    }
}
