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

import com.pack.hauphanvan.domain.Product;
import com.pack.hauphanvan.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM PRODUCTS";
		
		return jdbcTemplate.query(sql, new ProductMapper());
	}

	public List<Product> getProductsByCategory(String category) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY=:category";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category", category);
		
		return jdbcTemplate.query(sql, paramMap, new ProductMapper());
	}

	public List<Product> getProductsByFilter(Map<String, List<String>> filterParam) {
		String sql = "SELECT * FROM PRODUCTS WHERE MANUFACTURER IN (:brands) CATEGORY IN (:categories)";
		
		return jdbcTemplate.query(sql, filterParam, new ProductMapper());
	}

	public Product getProductById(String productId) {
		String sql = "SELECT * FROM PRODUCTS WHERE ID=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", productId);
		
		return (Product)jdbcTemplate.queryForObject(sql, paramMap, new ProductMapper());
	}

	public void addNewProduct(Product product) {
		String sql = "INSERT INTO PRODUCTS(ID, NAME, UNIT_PRICE, MANUFACTURER, CATEGORY, UNITS_IN_STOCK, UNITS_IN_ORDER, DESCRIPTION, PRODUCT_CONDITION, DISCONTINUED) VALUES(:id, :name, :unitPrice, :manufacturer, :category, :unitsInStock, :unitsInOrder,  :description, :condition, :discontinued)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", product.getProductId());
		paramMap.put("name", product.getName());
		paramMap.put("unitPrice", product.getUnitPrice());
		paramMap.put("manufacturer", product.getManufacturer());
		paramMap.put("category", product.getCategory());
		paramMap.put("unitsInStock", product.getUnitsInStock());
		paramMap.put("unitsInOrder", product.getUnitsInOrder());
		paramMap.put("description", product.getDescription());
		paramMap.put("condition", product.getCondition());
		paramMap.put("discontinued", product.isDiscontinued());
		
		jdbcTemplate.update(sql, paramMap);
	}
	
	private static final class ProductMapper implements RowMapper{

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setCondition(rs.getString("PRODUCT_CONDITION"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			
			
			return product;
		}
		
	}

}
