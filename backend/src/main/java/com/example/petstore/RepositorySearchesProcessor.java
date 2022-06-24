package com.example.petstore;

import com.example.petstore.domain.Rose;
import com.example.petstore.domain.Flower;
import com.example.petstore.domain.Gypsophila;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Flower>> {
    //오버라이드 행위 재정의, url설정
    @Override
    public EntityModel<Flower> process(EntityModel<Flower> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/water").withRel("water"));

        if(model.getContent() instanceof Rose)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/color").withRel("color"));

        if(model.getContent() instanceof Gypsophila)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/abundant").withRel("abundant"));

        return model;
    }
}