package com.neivor.prueba.roxxy.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class NeivorResponse {
    private String rc;
    private String msg;
    private Object data;

    public NeivorResponse() {
    }

    public NeivorResponse(String rc, String msg, Object data) {
        this.rc = rc;
        this.msg = msg;
        this.data = data;
    }


}
