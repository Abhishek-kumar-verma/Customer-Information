package com.intersoft.Assignment2.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.Customer;
import com.intersoft.Assignment2.service.CustomerService;

//@CrossOrigin("http://localhost:3000")

@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class CustomerController {
	
	@Autowired 
	CustomerService cService;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return cService.addCustomer(customer);
	}
    
	@GetMapping("/getAllCustomer")
	public ArrayList<Customer> getAllCustomer(){
		return cService.getAllCustomer();
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		return cService.getCustomerById(id);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		return cService.updateCustomer(customer,id);
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		return cService.deleteCustomerById(id);
	}
	
	@GetMapping("/customerExist/{id}")
	public boolean customerExistOrNot(@PathVariable int id) {
		return cService.customerExistOrNot(id);
	}
}
