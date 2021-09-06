package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.controller.contracts.IDetailInvocie;
import com.neivor.prueba.roxxy.dtos.request.DetailInvoiceGeneric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/invoice/detail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DetailInvocie implements IDetailInvocie {

    private static final Logger LOGGER = LogManager.getLogger(DetailInvocie.class);
    private static final Gson gson = new Gson();

    @Override
    public ResponseEntity<Object> registerNewInvoiceDetail(DetailInvoiceGeneric detailInvoiceGeneric) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getInvoiceDetail(DetailInvoiceGeneric detailInvoiceGeneric) {
        return null;
    }
}
