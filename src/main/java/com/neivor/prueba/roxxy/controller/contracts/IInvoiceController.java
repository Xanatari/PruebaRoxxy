package com.neivor.prueba.roxxy.controller.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;

@Api(value = "/invoice")
public interface IInvoiceController {

    ResponseEntity<Object> registerNewInvoice(InvoiceGenericRequest invoiceGenericRequest);
}
