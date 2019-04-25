package contracts.order

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url('/shipping/17') {
            queryParameters {
                parameter 'articles': 'apple'
                parameter 'articles': 'banana'
                parameter 'customer': 'mycustomer'
            }
        }
    }
    response {
        status 200
    }
}
