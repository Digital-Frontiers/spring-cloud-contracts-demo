package de.digitalfrontiers.demo.contract.testing.paymentservice.model.rest;

import lombok.Data;

@Data
public class Customer {

    private String name;

    private String iban;

    private String bic;
}
