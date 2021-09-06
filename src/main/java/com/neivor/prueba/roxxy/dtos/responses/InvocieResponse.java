package com.neivor.prueba.roxxy.dtos.responses;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ApiModel(description = "Resposne for invoice register")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class InvocieResponse {

    @ApiModelProperty(name = "Invoice Id", value = "Invoice Identification")
    int invoiceId;
}
