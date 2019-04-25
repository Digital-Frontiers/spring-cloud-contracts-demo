package de.digitalfrontiers.demo.contract.testing.orderservice.contract.tests;

import de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient.PaymentService;
import de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient.ShippingService;
import de.digitalfrontiers.demo.contract.testing.orderservice.web.OrderController;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

public class PaymentBase extends MockMvcBase {

    @Autowired
    private OrderController orderController;

    @MockBean
    private PaymentService paymentService;

    @MockBean
    private ShippingService shippingService;

    @Before
    public void setupOrders() {
        orderController.addOrder("banana", new ArrayList<>(), 37);
    }
}
