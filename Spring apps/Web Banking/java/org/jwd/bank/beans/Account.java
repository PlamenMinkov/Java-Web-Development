package org.jwd.bank.beans;

import java.util.HashMap;

import org.jwd.bank.entities.Customers;

public interface Account {
	HashMap<String, Customers> getAllCustomers();
	
	public Customers getUserAccountInfo(String accountName);

	public void updateUserAccountInfo(String accountName, Double amount);
	
	public void createUserAccountInfo(String accountName, Double amount, String currency);
}
