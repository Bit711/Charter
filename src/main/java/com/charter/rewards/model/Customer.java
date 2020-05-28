package com.charter.rewards.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Customer {

    @JsonProperty("customerName")
    private String name;
    @JsonProperty("months")
    private List<Month> month;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Month> getMonth() {
        return month;
    }

    public void setMonth(List<Month> month) {
        this.month = month;
    }
}
