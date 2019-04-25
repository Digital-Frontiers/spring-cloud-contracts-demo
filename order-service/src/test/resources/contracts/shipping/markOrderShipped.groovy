package contracts.shipping

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/order/0/shipped'
    }
    response {
        status 200
    }
}
