package com.example.retaildiscountspolicy.service;

import com.example.retaildiscountspolicy.Enum.CustomerTypeEnum;
import com.example.retaildiscountspolicy.model.Customer;
import com.example.retaildiscountspolicy.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Service
public class FinalCartService {


    private Map<ItemService, Integer> quantities = new LinkedHashMap<>();

    @Autowired
    private NormalDiscountService normalDiscountService;
    private Customer customer;

    public FinalCartService(){}

    public FinalCartService(Customer customer) {
        this.customer = customer;
        quantities = new LinkedHashMap<>();
    }

    public FinalCartService(Customer customer, NormalDiscountService normalDiscountService) {
        this.customer = customer;
        this.normalDiscountService = normalDiscountService;
    }

    public double total() {
        double result = 0.0;
        for (ItemService each : quantities.keySet()) {
            result += each.totalPriceForQuantity(quantities.get(each));
        }

        if (normalDiscountService != null) {
            result = normalDiscountService.applyDiscount(result);
        }

        return result;
    }

    public void add(Item itemToBuy, int howMany) {
        Item item;

        // Apply 30% discount in case of employee of store
        if (customer.getType() == CustomerTypeEnum.EMPLOYEE) {
            item = new PromotionDiscountService(itemToBuy, 30);
        }
        // Apply 10% discount in case of affiliate
        else if (customer.getType() == CustomerTypeEnum.AFFILIATE) {
            item = new PromotionDiscountService(itemToBuy, 10);
        }

        // If a user has been a customer for 2 or more years apply 5% discount
        else if (customer.getType() == CustomerTypeEnum.NORMAL &&
                ChronoUnit.YEARS.between(customer.getJoiningDate(), LocalDateTime.now()) >= 2) {
            item = new PromotionDiscountService(itemToBuy, 5);
        }

        else {
            item = itemToBuy;
        }

        int previousQuantity = quantities.containsKey(item)
                ? quantities.get(item)
                : 0;
        quantities.put((ItemService) item, previousQuantity + howMany);
    }

}
