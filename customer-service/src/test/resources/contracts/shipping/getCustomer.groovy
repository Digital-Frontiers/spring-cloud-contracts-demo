package contracts.payment

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/customer/banana'
    }
    response {
        status 200
        body([
                id : 'banana',
                name: 'Ban Ana',
                street: 'Magic Street 38',
                city: '0000 Bielefeld',
                iban: 'YY565678567895678',
                bic: 'OtherBank'
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
