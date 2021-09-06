package com.neivor.prueba.roxxy.dtos.request;

import com.neivor.prueba.roxxy.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DetailInvoiceGeneric {
    int invoiceNumber;
    int serviceType;
    String observations;
}
