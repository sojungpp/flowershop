package com.example.petstore;

import com.example.petstore.domain.Tulip;

import org.springframework.data.repository.CrudRepository;
//repository pattern 인터페이스
public interface TulipRepository extends CrudRepository<Tulip, Long>{    
}