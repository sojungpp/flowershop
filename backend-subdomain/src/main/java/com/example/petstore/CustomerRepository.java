package com.example.petstore;

import com.example.petstore.domain.Customer;

import org.springframework.data.repository.CrudRepository;
//repository pattern 인터페이스
public interface CustomerRepository extends CrudRepository<Customer, String>{   
}
