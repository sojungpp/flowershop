package com.example.petstore;


import com.example.petstore.domain.Flower;

import org.springframework.data.repository.CrudRepository;
//Repository pattern 인터페이스
public interface FlowerRepository extends CrudRepository<Flower, Long>{   
}
