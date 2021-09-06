package com.neivor.prueba.roxxy.service.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;
import com.neivor.prueba.roxxy.exceptions.InvocieNotFoundException;

public interface IInvoiceService {
    int registerRecord(InvoiceGenericRequest invoiceGenericRequest);

    void updateInvoice(InvoiceGenericRequest invoiceGenericRequest)throws InvocieNotFoundException;
}
