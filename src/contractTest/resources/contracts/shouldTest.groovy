package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url '/attachments'
        headers {
            header 'Content-Type': value(client(regex('multipart/form-data; ?boundary=.+')), server('multipart/form-data;boundary=AaB03x'))
        }
        multipart(
            file: named(
                name: $(c(regex(nonEmpty())), p('filename.csv')),
                content: $(c(regex(nonEmpty())), p('file content'))
            )
        )
    }
    response {
        status CREATED()
    }
}
