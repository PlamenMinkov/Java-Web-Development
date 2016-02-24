package org.jwd.bank.beans;

import org.jwd.bank.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationImpl implements Operation{

	@Autowired
	private Account acountBean;
	
	@Override
	public void withdraw(String accountName, double sum, String currency) {
		Customers.setLastCustumer(accountName);
		
		Customers thisAccount = acountBean.getUserAccountInfo(accountName);
		double amount = thisAccount.getAccountAmount();		
		
		amount -= sum;
		
		acountBean.updateUserAccountInfo(accountName, amount);
	}

	@Override
	public void deposit(String accountName, double sum, String currency) {
		Customers.setLastCustumer(accountName);
		
		Customers thisCustumer = acountBean.getUserAccountInfo(accountName);
		
		if (thisCustumer == null) {
			acountBean.createUserAccountInfo(accountName, sum, currency);
		}
		else {
			double amount = thisCustumer.getAccountAmount();
			
			amount += sum;
			
			acountBean.updateUserAccountInfo(accountName, amount);
		}
	}

}
