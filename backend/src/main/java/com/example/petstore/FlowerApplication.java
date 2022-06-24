package com.example.petstore;

import com.example.petstore.domain.Abundant;
import com.example.petstore.domain.Colorful;
import com.example.petstore.domain.Flower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//JSON형태로 데이터 반환
@RestController
//프록시패턴
@EnableAspectJAutoProxy

public class FlowerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlowerApplication.class, args);
	}

	//싱글톤 패턴 적용
	@Autowired
	FlowerRepository flowerRepository;

	@RequestMapping(method = RequestMethod.PUT, path="flowers/{flowerId}/water")
	public String freshFlower(@PathVariable(value = "flowerId") Long flowerId){
		Flower theFlower = flowerRepository.findById(flowerId).get();
		theFlower.water();
		flowerRepository.save(theFlower);
		return "물주기 완료";
	}
	@RequestMapping(method = RequestMethod.PUT, path="flowers/{flowerId}/nutrition")
	public String freshFlower2(@PathVariable(value = "flowerId") Long flowerId){
		Flower theFlower = flowerRepository.findById(flowerId).get();
		theFlower.nutrition();
		flowerRepository.save(theFlower);
		return "영양제주기 완료";
	}
	@RequestMapping(method = RequestMethod.PUT, path="flowers/{flowerId}/color")
	public String colorFlower(@PathVariable(value = "flowerId") Long flowerId){
		Flower theFlower = flowerRepository.findById(flowerId).get();
		if(theFlower instanceof Colorful){
			String message = ((Colorful)theFlower).color();
			flowerRepository.save(theFlower);
			return message;
		}
		return "색상 변경 불가능";
	}
	@RequestMapping(method = RequestMethod.PUT, path="flowers/{flowerId}/abundant")
	public String abundantFlower(@PathVariable(value = "flowerId") Long flowerId){
		Flower theFlower = flowerRepository.findById(flowerId).get();
		if(theFlower instanceof Abundant){
			String message = ((Abundant)theFlower).abundant();
			flowerRepository.save(theFlower);
			return message;
		}
		return "풍성도 추가 불가능";
	}
//PUT메소드를 통해 flowerID를 매핑 조건으로 두고 path링크로 데이터 보냄
	@RequestMapping(method = RequestMethod.PUT, path="roses/{flowerId}/color")
	public String colorRose(@PathVariable(value = "flowerId") Long flowerId){
		return colorFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="gypsophilas/{flowerId}/color")
	public String colorGypsophila(@PathVariable(value = "flowerId") Long flowerId){
		return colorFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="gypsophilas/{flowerId}/abundant")
	public String abundantGypsophila(@PathVariable(value = "flowerId") Long flowerId){
		return abundantFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="roses/{flowerId}/water")
	public String freshRose(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="tulips/{flowerId}/water")
	public String freshTulip(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="gypsophilas/{flowerId}/water")
	public String freshGypsophilas(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="tulips/{flowerId}/nutrition")
	public String freshTulip2(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower2(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="roses/{flowerId}/nutrition")
	public String freshRose2(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower2(flowerId);
	}
	@RequestMapping(method = RequestMethod.PUT, path="gypsophilas/{flowerId}/nutrition")
	public String freshGypsophila2(@PathVariable(value = "flowerId") Long flowerId){
		return freshFlower2(flowerId);
	}

}
