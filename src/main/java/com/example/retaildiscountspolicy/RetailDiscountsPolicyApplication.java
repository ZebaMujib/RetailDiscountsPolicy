package com.example.retaildiscountspolicy;

import com.example.retaildiscountspolicy.Enum.CustomerTypeEnum;
import com.example.retaildiscountspolicy.Enum.ItemEnum;
import com.example.retaildiscountspolicy.model.Customer;
import com.example.retaildiscountspolicy.model.Item;
import com.example.retaildiscountspolicy.service.FinalCartService;
import com.example.retaildiscountspolicy.service.NormalDiscountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication

public class RetailDiscountsPolicyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailDiscountsPolicyApplication.class, args);
	}


	public void run(String... args) throws Exception {

		Customer customer =new Customer(CustomerTypeEnum.NORMAL, "Zeba", LocalDateTime.of(2022, 9, 29, 6, 40, 45));
		Item item1 = new Item("RICE",37.50, ItemEnum.GROCERY, 5);
		Item item2 = new Item("Brush", 1.1, ItemEnum.NON_GROCERY, 1);
		NormalDiscountService normalDiscountService = new NormalDiscountService();
		FinalCartService cart = new FinalCartService(customer, normalDiscountService);
		cart.add(item1, item1.getQuantity());
		cart.add(item2, item2.getQuantity());
		System.out.println(cart.total());

	}
}
