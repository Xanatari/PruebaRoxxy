package com.neivor.prueba.roxxy.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PayerGenericRequest {
    String condoName;
    String payerName;
    String payerNationalId;
    String houseNumber;
    int invoiceAmmount;

}
