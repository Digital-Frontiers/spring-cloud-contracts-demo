package de.digitalfrontiers.demo.contract.testing.paymentservice.model.rest;

import lombok.Data;

@Data
public class Customer {

    private String id;

    private String name;

    private String street;

    private String city;

    private String iban;

    private String bic;
}
