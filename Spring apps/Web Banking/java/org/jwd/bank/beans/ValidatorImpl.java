package org.jwd.bank.beans;

import org.jwd.bank.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements Validator{
	
	@Autowired
	private Account acountBean;
	
	@Override
	public String validateOperationsData(String name, double amount, double sum, String operation) {
		if(name.length() > 3 && sum > 0) {
			Customers thisAccount = acountBean.getUserAccountInfo(name);
			
			if(thisAccount == null) {
				if(!operation.equals("deposit")) {
					return "You are a new cusstomer and you can't withdraw!";
				}
			}
			else{
				amount = thisAccount.getAccountAmount();
				
				if(amount < sum && operation.equals("withdraw")){
					return "You can't withdraw this sum!";
				}				
			}
		}
		else {
			return "Wrong name, or wrong sum!";
		}
		
		return "true";
	}

}
