package de.digitalfrontiers.demo.contract.testing.orderservice.service.restclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "de.digitalfrontiers.demo.contract.testing:shipping-service:1.0.0.RELEASE:stubs:8484"
)
public class ShippingServiceTest {

    @Autowired
    private ShippingService cut;

    @Test
    public void testRequestPayment() {
        ArrayList<String> articles = new ArrayList<>();
        articles.add("apple");
        articles.add("banana");
        assertThatCode(() -> cut.requestShipping(17L, articles, "mycustomer")).doesNotThrowAnyException();
    }
}
