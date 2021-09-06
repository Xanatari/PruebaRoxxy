package com.neivor.prueba.roxxy.service.contracts;

import com.neivor.prueba.roxxy.dtos.request.PayerGenericRequest;
import com.neivor.prueba.roxxy.exceptions.InvoiceAmmountErrException;
import com.neivor.prueba.roxxy.exceptions.InvoiceNationalIdNotFoundException;

public interface IPayerService {
    int registerPayer(PayerGenericRequest payerRequest) throws InvoiceNationalIdNotFoundException, InvoiceAmmountErrException;
}
