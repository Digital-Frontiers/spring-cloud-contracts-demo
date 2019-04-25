package de.digitalfrontiers.demo.contract.testing.orderservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private int id;

    private String customer;

    private List<String> articles;

    private int price;

    private boolean paid;

    private boolean shipped;
}
