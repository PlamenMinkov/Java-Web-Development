package org.jwd.bank.entities;

public class Customers {
	private static String lastCustumer = null;
	
	private String name;
	private double accountAmount;
	private String currency;
	
	public Customers() {
	}
	
	public Customers(String name, double accountAmount, String currency) {
		setName(name);
		setAccountAmount(accountAmount);
		setCurrency(currency);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static String getLastCustumer() {
		return lastCustumer;
	}

	public static void setLastCustumer(String lastCustumer) {
		Customers.lastCustumer = lastCustumer;
	}
}
