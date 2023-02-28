package com.intersoft.Assignment2.daoImpl;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intersoft.Assignment2.dao.CustomerDao;
import com.intersoft.Assignment2.entity.Customer;
import com.intersoft.Assignment2.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
     
	@Autowired
	CustomerRepository cRepo;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return cRepo.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		return cRepo.findById(id);
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> ans = new ArrayList<>();
		ans = (ArrayList<Customer>) cRepo.findAll();
		return ans;	
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
	         Customer oldCust = cRepo.findById(id).get();
		     oldCust.setName(customer.getName());
		     oldCust.setDescription(customer.getDescription());
		     oldCust.setAddress(customer.getAddress());
		     oldCust.setContact_email(customer.getContact_email());
		     oldCust.setCountry(customer.getCountry());
		     oldCust.setState(customer.getState());
		     oldCust.setCity(customer.getCity());
		     oldCust.setZip(customer.getZip());
		     oldCust.setContact_name(customer.getContact_name());
		     oldCust.setContact_phone(customer.getContact_phone());
		      oldCust.setIs_active(customer.isIs_active());
		      oldCust.setViolation_category(customer.getViolation_category());
		     oldCust.setTenant(customer.getTenant());
		     return cRepo.save(oldCust);
		
	}

	@Override
	public String deleteCustomerById(int id) {
		cRepo.deleteById(id);
		String str = new String();
		str += "customer with Id "+id +"deleted"; 
		return str;
	}	
	
	@Override
	public boolean customerExistOrNot( int id) {
		return cRepo.existsById(id);
	}

}
