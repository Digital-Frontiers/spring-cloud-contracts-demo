package de.digitalfrontiers.demo.contract.testing.shippingservice.contract.tests;

import de.digitalfrontiers.demo.contract.testing.shippingservice.model.Order;
import de.digitalfrontiers.demo.contract.testing.shippingservice.service.ShippingService;
import org.junit.After;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class OrderBase extends MockMvcBase {

    @MockBean
    private ShippingService shippingService;

    @After
    public void verification() {
        verify(shippingService).addOrder(eq(new Long(17)), any(Order.class));
    }

}
