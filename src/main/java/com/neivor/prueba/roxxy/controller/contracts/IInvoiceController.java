package com.neivor.prueba.roxxy.controller.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "/invoice")
public interface IInvoiceController {

    ResponseEntity<Object> registerNewInvoice(InvoiceGenericRequest invoiceGenericRequest);

    ResponseEntity<Object> detailByInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest);

    ResponseEntity<Object> updateInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest);

}
