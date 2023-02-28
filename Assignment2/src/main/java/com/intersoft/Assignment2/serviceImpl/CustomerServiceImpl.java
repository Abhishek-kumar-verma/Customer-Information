package com.intersoft.Assignment2.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intersoft.Assignment2.dao.CustomerDao;
import com.intersoft.Assignment2.entity.Countries;
import com.intersoft.Assignment2.entity.Customer;
import com.intersoft.Assignment2.service.CustomerService;

import antlr.collections.List;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao cDao;

	@Override
	public Customer addCustomer(Customer customer) {
		return cDao.addCustomer(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		return cDao.getCustomerById(id);
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		return cDao.getAllCustomer();
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		return cDao.updateCustomer(customer, id);
	}

	@Override
	public String deleteCustomerById(int id) {
		return cDao.deleteCustomerById(id);
	}
    
	@Override
	public boolean customerExistOrNot(int id) {
		return cDao.customerExistOrNot(id);
	}

}
