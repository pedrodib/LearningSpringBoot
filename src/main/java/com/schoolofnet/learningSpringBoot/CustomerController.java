package com.schoolofnet.learningSpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolofnet.learningSpringBoot.entity.Customer;
import com.schoolofnet.learningSpringBoot.entity.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public @ResponseBody List<Customer> all() { 
		return (List<Customer>) repository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Customer get(@PathVariable Long id){
		return repository.findOne(id);
	}
	
	@GetMapping(path = "/name/{name}")
	public @ResponseBody Customer getByName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@PostMapping
	public @ResponseBody Customer create(@RequestParam String name, @ RequestParam Integer age) {
		Customer customer = new Customer(name, age);
		
		if(name!= null && name.length() > 0 && age != null && age > 0) {
			repository.save(customer);
		}
		
		return customer;
	}
	
	@DeleteMapping(path = "/{id}")
	public @ResponseBody void delete(@PathVariable Long id) {
		Customer customer = repository.findOne(id);
		
		if(customer != null)
			repository.delete(id);
	}
}
