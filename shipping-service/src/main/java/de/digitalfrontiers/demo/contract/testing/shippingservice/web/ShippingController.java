package de.digitalfrontiers.demo.contract.testing.shippingservice.web;

import de.digitalfrontiers.demo.contract.testing.shippingservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.shippingservice.service.ShippingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
@Slf4j
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PutMapping("/{orderId}")
    public void requestShipping(
            @PathVariable("orderId") Long orderId,
            Order order
    ) {
        log.info("received order {}", orderId);
        shippingService.addOrder(orderId, order);
    }
}
