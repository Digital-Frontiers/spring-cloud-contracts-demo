package de.digitalfrontiers.demo.contract.testing.paymentservice.service;

import de.digitalfrontiers.demo.contract.testing.paymentservice.model.rest.Customer;
import de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient.OrderService;
import de.digitalfrontiers.demo.contract.testing.paymentservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient.CustomerService;
import de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient.PaymentProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentProviderService paymentProviderService;

    private Map<Long, Order> orders = new HashMap<>();

    public void addOrder(Long orderId, Order order) {
        if (!orders.containsKey(orderId)) {
            orders.put(orderId, order);
            order.setId(orderId);
            log.info("saved order {}, {}", orderId, order);
        }
    }

    public Order getOrder(long orderId) {
        return orders.get(orderId);
    }

    @Scheduled(fixedDelay = 30_000)
    public void handlePayments() {
        log.info("handling payments");
        orders.values().stream()
                .filter(Order::isNotPaid)
                .forEach(this::requestPayment);
    }

    private void requestPayment(Order order) {
        Customer customer = customerService.getCustomerPaymentInfo(order.getCustomer());
        log.info("requested customer details for customer {}, received: {}", order.getCustomer(), customer);

        if (order.getTransactionId() == null) {
            String transactionId = paymentProviderService.requestDebit(customer.getName(), customer.getIban(), customer.getBic());
            order.setTransactionId(transactionId);
            log.info("order {}: payment instructed, id {}", order.getId(), transactionId);
        }

        orderService.markPaid(order.getId());
        log.info("marked order paid: {}", order.getId());
        order.setPaid(true);
    }
}
