package contracts.customer

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/customer/tomato'
    }
    response {
        status 200
        body([
                id : 'tomato',
                name: 'Tom Ato',
                street: 'Fantasy Street 17',
                city: '1337 Leetcity',
                iban: 'XX12123412341234',
                bic: 'MyBank'
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
