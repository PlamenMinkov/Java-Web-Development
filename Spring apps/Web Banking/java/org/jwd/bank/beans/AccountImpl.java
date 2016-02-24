package org.jwd.bank.beans;

import java.util.HashMap;

import org.jwd.bank.entities.Customers;
import org.springframework.stereotype.Component;

@Component
public class AccountImpl implements Account{
	private HashMap<String, Customers> accounts;
	
	public AccountImpl() {
		this.accounts = new HashMap<String, Customers>();
		this.accounts.put("Ivan", new Customers("Ivan", 222.32, "BGN"));
		this.accounts.put("Stoian", new Customers("Stoian", 3425.33, "USD"));
		this.accounts.put("Atanas", new Customers("Atanas", 30.00, "EUR"));
	}
	
	@Override
	public HashMap<String, Customers> getAllCustomers() {
		return this.accounts;
	}

	@Override
	public Customers getUserAccountInfo(String accountName) {
		return accounts.get(accountName);
	}

	@Override
	public void updateUserAccountInfo(String accountName, Double amount) {
		Customers updatedAccount = accounts.get(accountName);
		
		if (updatedAccount != null) {
			updatedAccount.setAccountAmount(amount);
			accounts.put(accountName, updatedAccount);
		}
	}

	@Override
	public void createUserAccountInfo(String accountName, Double amount, String currency) {
		this.accounts.put(accountName, new Customers(accountName, amount, currency));		
	}

}
