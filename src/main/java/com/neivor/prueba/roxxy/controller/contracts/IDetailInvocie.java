package com.neivor.prueba.roxxy.controller.contracts;

import com.neivor.prueba.roxxy.dtos.request.DetailInvoiceGeneric;
import org.springframework.http.ResponseEntity;

public interface IDetailInvocie {
    ResponseEntity<Object> registerNewInvoiceDetail(DetailInvoiceGeneric detailInvoiceGeneric);

    ResponseEntity<Object> getInvoiceDetail(DetailInvoiceGeneric detailInvoiceGeneric);
}
