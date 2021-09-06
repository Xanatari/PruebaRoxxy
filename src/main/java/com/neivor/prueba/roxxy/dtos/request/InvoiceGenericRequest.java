package com.neivor.prueba.roxxy.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class InvoiceGenericRequest {

    String nationalId;
    int invoiceAmmount;
    int status;
    List<DetailInvoiceGeneric> detailInvoiceGenericList;
    Object data;

}
