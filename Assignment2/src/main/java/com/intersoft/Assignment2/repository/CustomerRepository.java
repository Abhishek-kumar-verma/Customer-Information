package com.intersoft.Assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intersoft.Assignment2.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
