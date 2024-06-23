package com.example.retaildiscountspolicy.service;

public class NormalDiscountService {

    public double applyDiscount(double totalAmount) {
        if (totalAmount < 100.0) {
            return totalAmount;
        } else {
            int discountFactor = (int)totalAmount / 100;
            double discount = (double)(discountFactor * 5);
            return totalAmount - discount;
        }
    }
}
