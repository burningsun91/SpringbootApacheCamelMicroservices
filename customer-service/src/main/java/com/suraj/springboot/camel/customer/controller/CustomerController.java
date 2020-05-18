package com.suraj.springboot.camel.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.springboot.camel.customer.model.Customer;
import com.suraj.springboot.camel.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/id/{cid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("cid") Long customerId) {
		return ResponseEntity.ok(customerService.getCustomer(customerId));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(Customer customer){
		return ResponseEntity.ok(customerService.saveCustomer(customer));
	}

}
