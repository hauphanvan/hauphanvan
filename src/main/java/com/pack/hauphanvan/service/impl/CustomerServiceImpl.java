package com.pack.hauphanvan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.hauphanvan.domain.Customer;
import com.pack.hauphanvan.repository.CustomerRepository;
import com.pack.hauphanvan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		
		return customerRepository.getAllCustomers();
	}

	public Customer getCustomerById(String customerId) {
		
		return customerRepository.getCustomerById(customerId);
	}

	public void addNewCustomer(Customer customer) {
		customerRepository.addNewCustomer(customer);
		
	}

}
