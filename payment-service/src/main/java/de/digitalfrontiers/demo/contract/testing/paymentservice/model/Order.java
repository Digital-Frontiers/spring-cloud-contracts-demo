package de.digitalfrontiers.demo.contract.testing.paymentservice.model;

import lombok.Data;

@Data
public class Order {

    private Long id;
    private int price;
    private String customer;
    private String transactionId;
    private boolean paid;

    public boolean isNotPaid() {
        return !paid;
    }
}
