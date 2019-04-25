package de.digitalfrontiers.demo.contract.testing.paymentprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@Slf4j
public class PaymentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProviderApplication.class, args);
	}

	@RestController
	public class Controller {
		@PostMapping
		public String handlePayment(
				@RequestParam("accountOwner") String accountOwner,
				@RequestParam("iban") String iban,
				@RequestParam("bic") String bic
		) {
			String transactionId = UUID.randomUUID().toString();
			log.info("generated transactionId {}", transactionId);
			return transactionId;
		}
	}

}
