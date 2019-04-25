package contracts.order

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url('/payment/42') {
            queryParameters {
                parameter 'price': '1337'
                parameter 'customer': 'mycustomer'
            }
        }
    }
    response {
        status 200
    }
}
