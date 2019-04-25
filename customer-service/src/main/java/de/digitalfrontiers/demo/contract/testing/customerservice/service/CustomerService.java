package de.digitalfrontiers.demo.contract.testing.customerservice.service;

import de.digitalfrontiers.demo.contract.testing.customerservice.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@Slf4j
public class CustomerService {

    HashMap<String, Customer> customers = new HashMap<>();

    public Customer getCustomer(String id) {
        if (!customers.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return customers.get(id);
    }

    @PostConstruct
    public void setupCustomers() {
        log.info("adding customers");
        Customer tomato = new Customer()
                .setId("tomato")
                .setName("Tom Ato")
                .setStreet("Fantasy Street 17")
                .setCity("1337 Leetcity")
                .setIban("XX12123412341234")
                .setBic("MyBank");
        customers.put("tomato", tomato);

        Customer banana = new Customer()
                .setId("banana")
                .setName("Ban Ana")
                .setStreet("Magic Street 38")
                .setCity("0000 Bielefeld")
                .setIban("YY565678567895678")
                .setBic("OtherBank");
        customers.put("banana", banana);

        Customer pineapple = new Customer()
                .setId("pineapple")
                .setName("Pine Apple")
                .setStreet("Answer Street 42")
                .setCity("101010 Universe")
                .setIban("ZZ78789078907890")
                .setBic("ThirdBank");
        customers.put("pineapple", pineapple);
    }

}
