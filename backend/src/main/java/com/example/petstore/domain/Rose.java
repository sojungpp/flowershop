package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//엔티티타입
@Entity
//구분컬럼 = rose
@DiscriminatorValue("rose")
//Flower, Colorful 상속
public class Rose extends Flower implements Colorful{
//Rose으로 type지정, Color지정
    public Rose() {
        setType("Rose");
        setColor("Red");
    }
//오버라이드 행위 재정의
    @Override
    public String color() {
        setPrice(getPrice()+1000);
        setColor("Pink");
        return "분홍색 색상 변경 완료";
    }
    @Override
    public void water(){
        setFreshness(getFreshness()+1);
    }
    @Override
    public void nutrition() {
        //슈퍼클래스 메소드 호출
        super.nutrition();
    }

    
}
