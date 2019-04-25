package de.digitalfrontiers.demo.contract.testing.shippingservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private List<String> articles;
    private String customer;
    private boolean shipped;

    public boolean isNotShipped() {
        return !shipped;
    }
}
