package de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(value = "order-service", url = "http://localhost:8181/order")
public interface OrderService {

    @RequestMapping(method = POST, path = "/{order}/paid")
    void markPaid(
            @PathVariable("order") long order);

}
