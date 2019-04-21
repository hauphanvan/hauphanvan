package com.pack.hauphanvan.repository;

import java.util.List;
import java.util.Map;

import com.pack.hauphanvan.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
	Customer getCustomerById(String customerId);
	void addNewCustomer(Customer customer);
}
