package com.schoolofnet.learningSpringBoot.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.schoolofnet.learningSpringBoot.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public Customer findByName(String name);
}
