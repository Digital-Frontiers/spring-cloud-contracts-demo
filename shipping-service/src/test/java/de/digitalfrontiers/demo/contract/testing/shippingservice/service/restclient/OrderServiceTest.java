package de.digitalfrontiers.demo.contract.testing.shippingservice.service.restclient;

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
        ids = "de.digitalfrontiers.demo.contract.testing:order-service:1.0.0.RELEASE:stubs:8181"
)
public class OrderServiceTest {

    @Autowired
    private OrderService cut;

    @Test
    public void testMarkShipped() {
        assertThatCode(() -> cut.markShipped(0)).doesNotThrowAnyException();
    }
}
