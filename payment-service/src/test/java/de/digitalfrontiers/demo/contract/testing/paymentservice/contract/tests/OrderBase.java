package de.digitalfrontiers.demo.contract.testing.paymentservice.contract.tests;

import de.digitalfrontiers.demo.contract.testing.paymentservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.paymentservice.service.PaymentService;
import org.junit.After;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class OrderBase extends MockMvcBase {

    @MockBean
    private PaymentService paymentService;

    @After
    public void verification() {
        verify(paymentService).addOrder(eq(new Long(42)), any(Order.class));
    }

}
