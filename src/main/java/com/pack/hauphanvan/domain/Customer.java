package com.pack.hauphanvan.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersion = 3678108792576131001L;
	private String customerId;
	private String password;
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	private String address;
	private long noOfOrdersMade;
	
	public Customer() {
		super();
	}
	
	public Customer(String customerId, String name, String address) {
		this.customerId=customerId;
		this.name=name;
		this.address=address;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the noOfOrdersMade
	 */
	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	/**
	 * @param noOfOrdersMade the noOfOrdersMade to set
	 */
	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime*result + (customerId == null? 0: customerId.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		
		Customer other = (Customer) obj;
		if(customerId == null) {
			if(other.customerId != null) {
				return false;
			}
		}else if(customerId != other.customerId)
			return false;
		
		return true;
	}
}
