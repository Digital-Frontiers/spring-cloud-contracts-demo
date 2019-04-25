package contracts.payment

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/customer/banana/address'
    }
    response {
        status 200
        body([
                name: 'Ban Ana',
                street: 'Magic Street 38',
                city: '0000 Bielefeld'
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
