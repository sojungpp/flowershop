package com.example.petstore.domain;

import javax.persistence.Embeddable;

//값타입정의
@Embeddable
public class Payment {
    String method;
    String status;
//setter&getter
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
