package com.intersoft.Assignment2.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.intersoft.Assignment2.entity.Customer;
@Component
public interface CustomerService {
	Customer addCustomer(Customer customer);
	Optional<Customer> getCustomerById(int id);
    ArrayList<Customer> getAllCustomer();
    Customer updateCustomer(Customer customer,int id);
    String deleteCustomerById(int id);
    boolean customerExistOrNot(int id);
}
