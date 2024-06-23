package com.example.retaildiscountspolicy.model;

import com.example.retaildiscountspolicy.Enum.CustomerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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

    public CustomerTypeEnum getType() {
        return this.type;
    }

    public String getUserName() {
        return this.userName;
    }

    public LocalDateTime getJoiningDate() {
        return this.joiningDate;
    }
}

