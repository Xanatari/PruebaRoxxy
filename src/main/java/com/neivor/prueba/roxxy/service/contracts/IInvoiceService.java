package com.neivor.prueba.roxxy.service.contracts;

import com.neivor.prueba.roxxy.dtos.request.InvoiceGenericRequest;

public interface IInvoiceService {
    int registerRecord(InvoiceGenericRequest invoiceGenericRequest);
}
