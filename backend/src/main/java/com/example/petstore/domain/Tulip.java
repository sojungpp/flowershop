package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//엔티티타입
@Entity
//구분컬럼 = tulip
@DiscriminatorValue("tulip")
//Flower 상속
public class Tulip extends Flower {
    public Tulip() {
        //type, color 지정
        setColor("Red");
        setType("Tulip");
    }
    //오버라이드 행위 재정의
    @Override
    public void water() {
        setFreshness(getFreshness() + 1);
    }

    @Override
    public void nutrition() {
        //슈퍼클래스 메소드 호출
        super.nutrition();
    }
}
