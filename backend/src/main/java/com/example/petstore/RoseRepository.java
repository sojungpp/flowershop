package com.example.petstore;

import com.example.petstore.domain.Rose;

import org.springframework.data.repository.CrudRepository;
//repository pattern 인터페이스
public interface RoseRepository extends CrudRepository<Rose, Long>{   
}