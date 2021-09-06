package com.neivor.prueba.roxxy.service.implementations;

import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import com.neivor.prueba.roxxy.service.contracts.IPayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PayerService implements IPayerService {
    private static final Logger LOGGER = LogManager.getLogger(PayerService.class);



    @Override
    public int registerPayer(PayerGenericRequest payerRequest) {
        LOGGER.info("Strat record Payer detail");
        return 0;
    }
}
