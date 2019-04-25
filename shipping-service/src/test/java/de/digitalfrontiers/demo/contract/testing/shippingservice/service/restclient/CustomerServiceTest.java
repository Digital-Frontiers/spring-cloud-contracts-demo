package de.digitalfrontiers.demo.contract.testing.shippingservice.service.restclient;

import de.digitalfrontiers.demo.contract.testing.shippingservice.model.rest.Customer;
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
        ids = "de.digitalfrontiers.demo.contract.testing:customer-service:1.0.0.RELEASE:stubs:8383"
)
public class CustomerServiceTest {

    @Autowired
    private CustomerService cut;

    @Test
    public void testGetCustomer() {
        Customer customer = cut.getCustomer("banana");

        assertThat(customer.getId()).isEqualTo("banana");
        assertThat(customer.getName()).isEqualTo("Ban Ana");
        assertThat(customer.getStreet()).isEqualTo("Magic Street 38");
        assertThat(customer.getCity()).isEqualTo("0000 Bielefeld");
        assertThat(customer.getIban()).isEqualTo("YY565678567895678");
        assertThat(customer.getBic()).isEqualTo("OtherBank");
    }

    @Test
    public void testGetCustomerAddress() {
        Customer customer = cut.getCustomerAddress("banana");
        assertThat(customer.getName()).isEqualTo("Ban Ana");
        assertThat(customer.getStreet()).isEqualTo("Magic Street 38");
        assertThat(customer.getCity()).isEqualTo("0000 Bielefeld");
    }
}
