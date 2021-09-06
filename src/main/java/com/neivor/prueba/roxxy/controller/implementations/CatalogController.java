package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.constants.BusinessConstansConnector;
import com.neivor.prueba.roxxy.controller.contracts.ICatalogsController;
import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.enums.Catalogtype;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/catalog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController implements ICatalogsController {

    private static final Logger LOGGER = LogManager.getLogger(CatalogController.class);
    private static final Gson gson = new Gson();

    @Override
    public ResponseEntity<Object> registerNewCatalog(@RequestHeader(BusinessConstansConnector.HEADER_CATALOG_TYPE) Catalogtype catalogtype, InvoiceGenericRequest invoiceGenericRequest) {
        LOGGER.info("Start process to register Catalog name {}", catalogtype.getCatalogType());


        return null;
    }

    @Override
    public ResponseEntity<Object> getAllcatalogs() {
        return null;
    }

    @Override
    public ResponseEntity<Object> getdetailByCatalog() {
        return null;
    }
}
