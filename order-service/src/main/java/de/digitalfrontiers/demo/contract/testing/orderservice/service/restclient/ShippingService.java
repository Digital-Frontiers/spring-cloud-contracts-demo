package de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "shipping-service", url = "http://localhost:8484")
public interface ShippingService {

    @PutMapping("/shipping/{orderId}")
    void requestShipping(@PathVariable("orderId") long orderId,
                           @RequestParam("articles") List<String> articles,
                           @RequestParam("customer") String customer);
}
