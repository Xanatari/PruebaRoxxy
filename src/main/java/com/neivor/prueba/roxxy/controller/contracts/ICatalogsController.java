package com.neivor.prueba.roxxy.controller.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.enums.Catalogtype;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;

@Api(value = "/catalogs")
public interface ICatalogsController {

    ResponseEntity<Object> registerNewCatalog(Catalogtype catalogtype, InvoiceGenericRequest invoiceGenericRequest);

    ResponseEntity<Object> getAllcatalogs();

    ResponseEntity<Object> getdetailByCatalog();
}
