package com.example.petstore;

import com.example.petstore.domain.CartItem;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

//bean등록
@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<CartItem>> {
    //오버라이딩 행위 재정의 - URL링크로 받도록, API유지
    @Override
    public EntityModel<CartItem> process(EntityModel<CartItem> model) {
        model.add(Link.of(model.getContent().getFlower()).withRel("flower"));
        return model;
    }
}