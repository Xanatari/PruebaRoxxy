package com.neivor.prueba.roxxy.dtos.responses;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ApiModel(description = "Resposne for Detail Invoice")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PayerGenericResponse {
    String payerName;
    String payerNationalId;
    int ammount;
}
