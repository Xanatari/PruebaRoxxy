package com.neivor.prueba.roxxy.dtos.responses;

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
