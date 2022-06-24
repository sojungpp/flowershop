package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//엔티티타입
@Entity
//구분컬럼 = gypsophila
@DiscriminatorValue("gypsophila")
//Flower와 Abundant, Colorful 상속 (인터페이스 다중상속)
public class Gypsophila extends Flower implements Abundant,Colorful{
//type, color 지정
    public Gypsophila() {
        setType("Gypsophila");
        setColor("Red");
    }
    //오버라이드 행위 재정의
    @Override
    public String abundant() {
        setPrice(getPrice()+2000);
        return "꽃이 풍성해졌어요.";
    }
    @Override
    public String color() {
        setPrice(getPrice()+1500);
        setColor("Pink");
        return "분홍색 색상 변경 완료";
    }
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
