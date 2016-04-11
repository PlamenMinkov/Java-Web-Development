package org.jwd.gamenight.security;

import java.util.ArrayList;
import java.util.List;

import org.jwd.gamenight.dao.account.AccountDao;
import org.jwd.gamenight.entity.account.Account;
import org.jwd.gamenight.entity.account.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDao.getAccount(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (Authority authority : account.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		
		return new User(account.getUsername(), account.getPassword(), authorities);
	}
}