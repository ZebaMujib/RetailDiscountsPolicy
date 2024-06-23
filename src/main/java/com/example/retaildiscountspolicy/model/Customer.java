package com.example.retaildiscountspolicy.model;

import com.example.retaildiscountspolicy.Enum.CustomerTypeEnum;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Data
@ComponentScan(basePackages={"com.example"})
public class Customer {


    private final CustomerTypeEnum type;
    private final String userName;
    private final LocalDateTime joiningDate;


    public Customer(CustomerTypeEnum type, String userName) {
        this.type = type;
        this.userName = userName;
        this.joiningDate = LocalDateTime.now();
    }

    public Customer(CustomerTypeEnum type, String userName, LocalDateTime joiningDate) {
        this.type = type;
        this.userName = userName;
        this.joiningDate = joiningDate;
    }
}

