package com.example.petstore.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
//엔티티타입
@Entity
public class Customer {
//아이디이자 기본키
    @Id
    String id;
//임베디드타입
    @Embedded
    Address address;
//setter&getter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }   
}
