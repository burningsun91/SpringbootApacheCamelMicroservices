package com.suraj.springboot.camel.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.springboot.camel.customer.model.Customer;
import com.suraj.springboot.camel.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(e -> customers.add(e));
		return customers;
	}
	
	public Customer getCustomer(Long customerId) {
		Optional<Customer> optCustomer = customerRepository.findById(customerId);
		if(optCustomer.isPresent()) {
			return optCustomer.get();
		}else {
			return new Customer(0L, 0L, 0L, "Unknown");
		}
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
