package de.digitalfrontiers.demo.contract.testing.paymentservice.service;

import de.digitalfrontiers.demo.contract.testing.paymentservice.model.Order;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL, // typically REMOTE -> Stubs in Artifactory or Nexus or ...
        ids = {"de.digitalfrontiers.demo.contract.testing:customer-service:1.0.0.RELEASE:stubs:8383",
                "de.digitalfrontiers.demo.contract.testing:order-service:1.0.0.RELEASE:stubs:8181",
                "de.digitalfrontiers.demo.contract.testing:payment-provider-contract-proxy:1.0.0.RELEASE:stubs:9191"}
)
public class PaymentServiceTest {

    @Autowired
    private PaymentService cut;

    @Test
    public void testHandlePayments() {
        // setup
        Order order = new Order();
        order.setCustomer("tomato");
        order.setPrice(42);
        cut.addOrder(0L, order);

        // make call
        cut.handlePayments();

        // do assertions
        Order order1 = cut.getOrder(0L);
        assertThat(order1.getTransactionId()).isNotNull();
        assertThat(order1.isPaid()).isTrue();
    }

    @Test
    public void testHandlePaymentsMarkingOrderAsPaidFails() {
        // setup
        Order order = new Order();
        order.setCustomer("tomato");
        order.setPrice(42);
        cut.addOrder(-1L, order);

        // make call
        try {
            // expect exceptions because order could not be marked as paid (yes not handling is ugly, but that's a demo)
            cut.handlePayments();
        } catch (FeignException fe) {
            assertThat(fe.status()).isEqualTo(404);
        }

        // do assertions
        Order order1 = cut.getOrder(-1L);
        assertThat(order1.getTransactionId()).isNotNull();
        assertThat(order1.isPaid()).isFalse();
    }
}
