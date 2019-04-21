package com.pack.hauphanvan.service;

import java.util.List;

import com.pack.hauphanvan.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomerById(String customerId);
	void addNewCustomer(Customer customer);
}
