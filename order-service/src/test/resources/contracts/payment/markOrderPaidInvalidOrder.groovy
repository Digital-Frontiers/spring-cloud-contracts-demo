package contracts.order

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/order/-1/paid'
    }
    response {
        status 404
    }
}

