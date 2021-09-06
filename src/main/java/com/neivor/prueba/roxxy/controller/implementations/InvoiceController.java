package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.controller.contracts.IInvoiceController;
import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.dtos.responses.NeivorResponse;
import com.neivor.prueba.roxxy.service.contracts.IInvoiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/invoice" , consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
public class InvoiceController implements IInvoiceController {

    private static final Logger LOGGER = LogManager.getLogger(InvoiceController.class);
    private static final Gson gson = new Gson();

    IInvoiceService iInvoiceService;

    @Autowired
    public InvoiceController(IInvoiceService iInvoiceService) {
        this.iInvoiceService = iInvoiceService;
    }

    @Override
    @PostMapping(path = "/new")
    public ResponseEntity<Object> registerNewInvoice(InvoiceGenericRequest invoiceGenericRequest) {

        LOGGER.info("Start save record to new invoice");
        iInvoiceService.registerRecord(invoiceGenericRequest);
        NeivorResponse neivorResponse = new NeivorResponse("00", "OK", null);
        return new ResponseEntity<>(gson.toJson(neivorResponse), HttpStatus.OK);
    }
}
