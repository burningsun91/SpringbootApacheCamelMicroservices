package com.suraj.springboot.camel.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suraj.springboot.camel.customer.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
