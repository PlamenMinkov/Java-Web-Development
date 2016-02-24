package org.jwd.bank.beans;

import org.springframework.context.annotation.Scope;

@Scope("request") 
public interface Operation {
	void withdraw(String accountName, double sum, String currency);
	void deposit(String accountName, double sum, String currency);	
}
