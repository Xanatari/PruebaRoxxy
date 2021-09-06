package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.controller.contracts.IInvoiceController;
import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.dtos.responses.InvocieResponse;
import com.neivor.prueba.roxxy.dtos.responses.NeivorResponse;
import com.neivor.prueba.roxxy.service.contracts.IInvoiceService;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/invoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<Object> registerNewInvoice(@RequestBody InvoiceGenericRequest invoiceGenericRequest) {

        LOGGER.info("Start save record to new invoice");

        return new ResponseEntity<>(gson.toJson(NeivorResponse.builder()
                .rc("0")
                .msg("OK")
                .data(
                        InvocieResponse.builder()
                                .invoiceId(iInvoiceService.registerRecord(invoiceGenericRequest))
                                .build())
                .build()
        ), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/detail")
    public ResponseEntity<Object> detailByInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest) {

        LOGGER.info("Start save record to new invoice");

        return new ResponseEntity<>(gson.toJson(NeivorResponse.builder()
                .rc("0")
                .msg("OK")
                .data(
                        InvocieResponse.builder()
                                .invoiceId(iInvoiceService.registerRecord(invoiceGenericRequest))
                                .build())
                .build()
        ), HttpStatus.OK);
    }

    @Override
    @PutMapping (path = "/status/{invoiceId}")
    public ResponseEntity<Object> updateInvoiceId(@RequestBody InvoiceGenericRequest invoiceGenericRequest,
                                                  @PathVariable @NotNull int invoiceId) {
        return null;
    }


}
