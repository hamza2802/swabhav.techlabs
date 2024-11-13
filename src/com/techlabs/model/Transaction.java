package com.techlabs.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private String productId;
    private int quantity;
    private Date date;
    private String type; // "ADD" or "REMOVE"

    public Transaction(String productId, int quantity, Date date, String type) {
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}

