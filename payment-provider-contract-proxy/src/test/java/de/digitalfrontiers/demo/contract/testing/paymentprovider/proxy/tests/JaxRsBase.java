package de.digitalfrontiers.demo.contract.testing.paymentprovider.proxy.tests;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JaxRsBase {

    protected Client client;
    protected WebTarget webTarget;

    @Before
    public void setup() {
        client = ClientBuilder.newClient();
        webTarget = client.target("http://localhost:9191");
    }
}
