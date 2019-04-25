package de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient;

import de.digitalfrontiers.demo.contract.testing.paymentservice.model.rest.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "customer-service", url = "http://localhost:8383/customer")
public interface CustomerService {

    @RequestMapping(method =  GET, path = "/{customer}/payment")
    Customer getCustomerPaymentInfo(
            @PathVariable("customer") String customer
    );
}
