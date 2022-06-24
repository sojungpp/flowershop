package com.example.petstore.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//엔티티, JPA가 관리
@Entity
public class CartItem {
//아이디이자 기본키 맵핑
    @Id @GeneratedValue
    Long id;
//일대일관계
    @OneToOne
    Customer customer;
//임베디드타입
    @Embedded
    Payment payment;
//getter&setter
    String flower;
    public String getFlower() {
        return flower;
    }
    public void setFlower(String flower) {
        this.flower = flower;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
