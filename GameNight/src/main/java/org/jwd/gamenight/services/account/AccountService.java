package org.jwd.gamenight.services.account;

import java.util.HashMap;
import java.util.List;

import org.jwd.gamenight.entity.account.Account;

public interface AccountService {
	List<Account> getAccounts(String username);
	
	public Account getUserAccountInfo(String accountName);

	public void updateUserAccountInfo(String accountName, Double amount);
	
	public void createUserAccountInfo(String username, String password, 
			String firstName, String lastName, int avatar);
	
	public int addActivePeriod(int accountId);
}
