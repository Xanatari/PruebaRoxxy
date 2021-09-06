package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.controller.contracts.IPayerController;
import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PayerController implements IPayerController {

    private static final Logger LOGGER = LogManager.getLogger(PayerController.class);
    private static final Gson gson = new Gson();

    @Override
    public ResponseEntity<Object> registerNewPayer(@RequestBody PayerGenericRequest payerRequest) {
        LOGGER.info("Start process to register Catalog name {}");
        return null;
    }

    @Override
    public ResponseEntity<Object> detailByPayerId(@RequestBody PayerGenericRequest payerRequest) {
        return null;
    }
}
