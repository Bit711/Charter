package com.charter.rewards.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Month {

    private String month;
    private List<Integer> transactions;

    public Month(String month) {
        this.month = month;
    }

    public Month() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<Integer> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Integer> transactions) {
        this.transactions = transactions;
    }
}
