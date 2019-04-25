package de.digitalfrontiers.demo.contract.testing.customerservice.web;

import de.digitalfrontiers.demo.contract.testing.customerservice.model.Customer;
import de.digitalfrontiers.demo.contract.testing.customerservice.service.CustomerService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customer}")
    public Customer getCustomer(@PathVariable("customer") String customer) {
        log.info("received request for customer {}", customer);
        return customerService.getCustomer(customer);
    }

    @GetMapping("/{customer}/address")
    public AddressResponse getAddress(@PathVariable("customer") String customer) {
        return AddressResponse.from(customerService.getCustomer(customer));
    }

    @GetMapping("/{customer}/payment")
    public PaymentResponse getPaymentInfo(@PathVariable("customer") String customer) {
        return PaymentResponse.from(customerService.getCustomer(customer));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String catchIllegalArgumentException() {
        return "This customer does not exist";
    }

    @Data
    public static class AddressResponse {

        private String name;
        private String street;
        private String city;

        public static AddressResponse from(Customer customer) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setName(customer.getName());
            addressResponse.setCity(customer.getCity());
            addressResponse.setStreet(customer.getStreet());
            return addressResponse;
        }
    }

    @Data
    public static class PaymentResponse {

        private String iban;
        private String bic;

        public static PaymentResponse from(Customer customer) {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setIban(customer.getIban());
            paymentResponse.setBic(customer.getBic());
            return paymentResponse;
        }
    }
}
