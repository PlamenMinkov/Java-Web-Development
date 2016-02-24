package org.jwd.bank.beans;

public interface Validator {
	String validateOperationsData(String name, double amount, double sum, String Operation);
}
