package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url('/') {
            queryParameters {
                parameter 'accountOwner': $(regex('.+'))
                parameter 'iban': $(regex('.+'))
                parameter 'bic': $(regex('.+'))
            }
        }
    }
    response {
        status 200
        body($(regex('[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}')))
    }
}
