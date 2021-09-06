package com.neivor.prueba.roxxy.controller.implementations;

import com.google.gson.Gson;
import com.neivor.prueba.roxxy.controller.contracts.IPayerController;
import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import com.neivor.prueba.roxxy.dtos.responses.InvocieResponse;
import com.neivor.prueba.roxxy.dtos.responses.NeivorResponse;
import com.neivor.prueba.roxxy.exceptions.GenericException;
import com.neivor.prueba.roxxy.exceptions.InvocieNotFoundException;
import com.neivor.prueba.roxxy.exceptions.InvoiceAmmountErrException;
import com.neivor.prueba.roxxy.exceptions.InvoiceNationalIdNotFoundException;
import com.neivor.prueba.roxxy.service.contracts.IPayerService;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PayerController implements IPayerController {

    private static final Logger LOGGER = LogManager.getLogger(PayerController.class);
    private static final Gson gson = new Gson();

    IPayerService iPayerService;

    @Autowired
    public PayerController(IPayerService iPayerService) {
        this.iPayerService = iPayerService;
    }

    @Override
    @PostMapping(path = "/new")
    public ResponseEntity<Object> registerNewPayer(@RequestBody PayerGenericRequest payerRequest) {
        try{
            LOGGER.info("Start process to register Catalog name {}");
            return new ResponseEntity<>(gson.toJson(NeivorResponse.builder()
                    .rc("0")
                    .msg("OK")
                    .data(
                            InvocieResponse.builder()
                                    .invoiceId(iPayerService.registerPayer(payerRequest))
                                    .build())
                    .build()
            ), HttpStatus.OK);

        }catch (InvoiceNationalIdNotFoundException invoiceNationalIdNotFoundException){
            LOGGER.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(invoiceNationalIdNotFoundException), HttpStatus.BAD_REQUEST);
        }catch ( InvoiceAmmountErrException invoiceAmmountErrException){
            LOGGER.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(invoiceAmmountErrException), HttpStatus.BAD_REQUEST);
        }catch (Exception e ){
            LOGGER.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    @GetMapping(path = "/detail/{invoiceId}")
    public ResponseEntity<Object> detailByPayerId(@RequestBody PayerGenericRequest payerRequest,
                                                  @PathVariable @NotNull int invoiceId) {

        try{
            LOGGER.info("Start process to register Catalog name {}");
            return new ResponseEntity<>(gson.toJson(NeivorResponse.builder()
                    .rc("0")
                    .msg("OK")
                    .data(iPayerService.payerInfo(invoiceId))
                    .build()
            ), HttpStatus.OK);

        }catch ( InvocieNotFoundException invocieNotFoundException){
            LOGGER.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(invocieNotFoundException), HttpStatus.BAD_REQUEST);
        }catch (Exception e ){
            LOGGER.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.BAD_REQUEST);
        }
    }
}
