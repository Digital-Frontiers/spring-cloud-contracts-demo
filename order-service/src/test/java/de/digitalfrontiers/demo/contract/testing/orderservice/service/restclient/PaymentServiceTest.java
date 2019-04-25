package de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "de.digitalfrontiers.demo.contract.testing:payment-service:1.0.0.RELEASE:stubs:8282"
)
public class PaymentServiceTest {

    @Autowired
    private PaymentService cut;

    @Test
    public void testRequestPayment() {
        assertThatCode(() -> cut.requestPayment(42, 1337, "mycustomer")).doesNotThrowAnyException();
    }
}
