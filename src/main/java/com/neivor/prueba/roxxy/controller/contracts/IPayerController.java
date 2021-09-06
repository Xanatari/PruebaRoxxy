package com.neivor.prueba.roxxy.controller.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import com.neivor.prueba.roxxy.enums.Catalogtype;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;

@Api(value = "/payer")
public interface IPayerController {

    ResponseEntity<Object> registerNewPayer( PayerGenericRequest payerGenericRequest);
    ResponseEntity<Object> detailByPayerId( PayerGenericRequest payerGenericRequest);
}
