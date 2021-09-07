package com.neivor.prueba.roxxy.controller.contracts;


import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.dtos.responses.InvocieResponse;
import com.neivor.prueba.roxxy.exceptions.GenericException;
import com.neivor.prueba.roxxy.exceptions.InvocieNotFoundException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface IInvoiceController {
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Invoice process",response = InvocieResponse.class),
            @ApiResponse(code = 400, message = "Error not found Invoice", response = InvocieNotFoundException.class),
            @ApiResponse(code = 500, message = "Internal server error generic exception", response = GenericException.class)
    }
    )
    ResponseEntity<Object> registerNewInvoice(InvoiceGenericRequest invoiceGenericRequest);
    ResponseEntity<Object> detailByInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest);
    ResponseEntity<Object> updateInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest);
    ResponseEntity<Object> reverseInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest);

}
