package com.example.petstore.domain;

import javax.persistence.Embeddable;

//값타입정의
@Embeddable
public class Address {
    String detail;
    String zipcode;
//setter&getter
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
