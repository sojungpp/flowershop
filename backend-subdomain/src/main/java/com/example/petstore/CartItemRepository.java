package com.example.petstore;

import com.example.petstore.domain.*;

import org.springframework.data.repository.CrudRepository;
//repository pattern 인터페이스
public interface CartItemRepository extends CrudRepository<CartItem, Long>{    
}
