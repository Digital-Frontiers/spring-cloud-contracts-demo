package de.digitalfrontiers.demo.contract.testing.paymentservice.service.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "payment-provider", url = "http://localhost:9191")
public interface PaymentProviderService {

    @PostMapping
    String requestDebit(@RequestParam("accountOwner") String accountOwner,
                      @RequestParam("iban") String iban,
                      @RequestParam("bic") String bic);
}
