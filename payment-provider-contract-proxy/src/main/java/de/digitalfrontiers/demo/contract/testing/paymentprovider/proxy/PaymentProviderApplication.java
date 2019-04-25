package de.digitalfrontiers.demo.contract.testing.paymentprovider.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class PaymentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProviderApplication.class, args);
	}

}
