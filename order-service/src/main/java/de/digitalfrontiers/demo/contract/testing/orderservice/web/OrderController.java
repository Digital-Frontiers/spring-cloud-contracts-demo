package de.digitalfrontiers.demo.contract.testing.orderservice.web;

import de.digitalfrontiers.demo.contract.testing.orderservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient.PaymentService;
import de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient.ShippingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ShippingService shippingService;

    private List<Order> orders = Collections.synchronizedList(new ArrayList<>());

    @PostMapping
    public Order addOrder(@RequestParam("customer") String customer,
                          @RequestParam("articles") ArrayList<String> articles,
                          @RequestParam("price") int price) {
        Order order = new Order();
        order.setArticles(articles);
        order.setCustomer(customer);
        order.setPrice(price);
        synchronized (orders) {
            order.setId(orders.size());
            orders.add(order);
            log.info("Saved order {}", order);
        }

        paymentService.requestPayment(order.getId(), order.getPrice(), order.getCustomer());
        log.info("requested payment: {}, {}, {}", order.getId(), order.getPrice(), order.getCustomer());

        shippingService.requestShipping(order.getId(), order.getArticles(), order.getCustomer());
        log.info("requested shipping: {}, {}, {}", order.getId(), order.getArticles(), order.getCustomer());

        return order;
    }

    @PostMapping("/{orderId}/paid")
    public void markOrderPaid(@PathVariable("orderId") int orderId) {
        Order order = this.orders.get(orderId);
        order.setPaid(true);
        log.info("marked order {} paid", orderId);
    }

    @PostMapping("/{orderId}/shipped")
    public void markOrderConveyed(@PathVariable("orderId") int orderId) {
        Order order = this.orders.get(orderId);
        order.setShipped(true);
        log.info("marked order {} shipped", orderId);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String catchIndexOutOfBoundsException() {
        return "This order does not exist";
    }
}
