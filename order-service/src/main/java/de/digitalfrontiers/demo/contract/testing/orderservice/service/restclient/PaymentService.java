package de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "payment-service", url = "http://localhost:8282")
public interface PaymentService {

    @PutMapping("/payment/{orderId}")
    void requestPayment(@PathVariable("orderId") long orderId,
                       @RequestParam("price") int price,
                       @RequestParam("customer") String customer);
}
