package com.example.petstore.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//엔티티타입
@Entity
//flower_type 정의, 상속관계 매핑
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,
    name = "flower_type",
    columnDefinition = "CHAR(5)"
)
public abstract class Flower {  
    //setter&getter   
    //기본키 맵핑
    @Id @GeneratedValue
    Long id;    
        public Long getId() {
            return id;
        }
    private int price;
        public int getPrice() {
            return price;
        }
        protected void setPrice(int price) {
            this.price = price;
        }
    String name; 
        public String getName() {
            return name;
        }
        public void setName(String name) {
            if(name==null) throw new IllegalArgumentException("이름은 필수");
            this.name = name;
        }
    String type;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }

    String color;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    private int freshness = 0;
        public int getFreshness() {
            return freshness;
        }
        protected void setFreshness(int freshness) {
            //if문 조건 따라 비교 후 출력 (최소 기준 설정)
            if(Math.abs(this.freshness - freshness) > 1 )
                this.freshness = freshness;
            else    
                throw new IllegalArgumentException("Freshness change is too small");
        } 
    //water 실행 시, freshness 1씩 증가
    public void water(){
        setFreshness(getFreshness()+1);
    }
    //nutrition 실행 시, freshness 1씩 증가
    public void nutrition(){
        setFreshness(getFreshness()+1);
    }

    //주소 가져오는 것
    @Override
    public String toString() { 
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'" + ">" + this.getClass().getSimpleName() + "</a>";
    }
    
}
