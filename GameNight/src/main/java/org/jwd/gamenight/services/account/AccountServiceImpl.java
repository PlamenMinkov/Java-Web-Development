package org.jwd.gamenight.services.account;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.jwd.gamenight.dao.account.AccountDao;
import org.jwd.gamenight.entity.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public List<Account> getAccounts(String username) {
		return accountDao.getAccounts(username);
	}

	@Override
	public Account getUserAccountInfo(String accountName) {
		return accountDao.getAccount(accountName);
	}

	@Override
	public void updateUserAccountInfo(String accountName, Double amount) {
		Account updatedAccount = accountDao.getAccount(accountName);
		
		if (updatedAccount != null) {
			//updatedAccount.setAccountAmount(amount);
			//accounts.put(accountName, updatedAccount);
		}
	}

	@Override
	public void createUserAccountInfo(String username, String password, 
			String firstName, String lastName, int avatar) {
		accountDao.addAccount(new Account(username, password, firstName, lastName, avatar));
	}

	@Override
	public int addActivePeriod(int accountId) {

		return accountDao.addActivePeriod(accountId);
	}

}
