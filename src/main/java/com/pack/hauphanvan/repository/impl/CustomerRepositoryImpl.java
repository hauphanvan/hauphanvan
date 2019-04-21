package com.pack.hauphanvan.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack.hauphanvan.domain.Customer;
import com.pack.hauphanvan.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Customer> getAllCustomers() {
		String sql = "SELECT * FROM CUSTOMERS";
		
		return jdbcTemplate.query(sql, new CustomerMapper());
	}

	public Customer getCustomerById(String customerId) {
		String sql = "SELECT * FROM CUSTOMERS WHERE ID=:id";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", customerId);
		
		return (Customer)jdbcTemplate.queryForObject(sql, param, new CustomerMapper());
	}

	public void addNewCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMERS(ID, NAME, ADDRESS, NO_OF_ORDERS_MADE) VALUES(:id, :name, :address, :noOfOrdersMade)";
		Map<String, Object> mapParam = new HashMap<String, Object>();
		mapParam.put("id", customer.getCustomerId());
		mapParam.put("name", customer.getName());
		mapParam.put("address", customer.getAddress());
		mapParam.put("noOfOrdersMade", customer.getNoOfOrdersMade());
		
		jdbcTemplate.update(sql, mapParam);
	}
	
	private static final class CustomerMapper implements RowMapper{

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getLong("NO_OF_ORDERS_MADE"));
			
			return customer;
		}

	}
}
