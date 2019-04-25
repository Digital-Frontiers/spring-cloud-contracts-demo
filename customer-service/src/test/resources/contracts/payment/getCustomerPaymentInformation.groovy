package contracts.customer

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/customer/tomato/payment'
    }
    response {
        status 200
        body([
                name: 'Tom Ato',
                iban: 'XX12123412341234',
                bic: 'MyBank'
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
