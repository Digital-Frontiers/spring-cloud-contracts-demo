package de.digitalfrontiers.demo.contract.testing.shippingservice.service;

import de.digitalfrontiers.demo.contract.testing.shippingservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.shippingservice.model.rest.Customer;
import de.digitalfrontiers.demo.contract.testing.shippingservice.service.restclient.CustomerService;
import de.digitalfrontiers.demo.contract.testing.shippingservice.service.restclient.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ShippingService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    private Map<Long, Order> orders = new HashMap<>();

    public void addOrder(Long orderId, Order order) {
        if (!orders.containsKey(orderId)) {
            order.setId(orderId);
            orders.put(orderId, order);
            log.info("saved order {}, {}", orderId, order);
        }
    }

    @Scheduled(fixedDelay = 30_000)
    public void handleShippings() {
        log.info("handling shippings");
        orders.values().stream()
                .filter(Order::isNotShipped)
                .forEach(this::shipOrder);
    }

    private void shipOrder(Order order) {
        Customer customer = customerService.getCustomer(order.getCustomer());
        log.info("requested customer details for customer {}, received: {}", order.getCustomer(), customer);

        orderService.markShipped(order.getId());
        log.info("marked order shipped: {}", order.getId());
        order.setShipped(true);
    }
}
