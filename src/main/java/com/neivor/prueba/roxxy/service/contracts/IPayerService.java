package com.neivor.prueba.roxxy.service.contracts;

import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;

public interface IPayerService {
    int registerPayer(PayerGenericRequest payerRequest);
}
