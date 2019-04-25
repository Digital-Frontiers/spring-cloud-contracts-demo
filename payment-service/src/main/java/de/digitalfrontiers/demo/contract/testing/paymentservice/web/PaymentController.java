package de.digitalfrontiers.demo.contract.testing.paymentservice.web;

import de.digitalfrontiers.demo.contract.testing.paymentservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PutMapping("/{orderId}")
    public void requestPayment(
            @PathVariable("orderId") Long orderId,
            Order order
    ) {
        log.info("received order {}", orderId);
        paymentService.addOrder(orderId, order);
    }
}
