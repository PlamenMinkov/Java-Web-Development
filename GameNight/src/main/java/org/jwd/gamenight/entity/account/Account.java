package org.jwd.gamenight.entity.account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.jwd.gamenight.entity.account.Authority;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String lastCustumer = null;
	
	@Id
	@Column( name = "ACCOUNT_ID" )
	private int account_id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ACTIVE_PERIOD")
	private int activePeriod;
	
	@Column(name = "AVATAR")
	private int avatar;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ACCOUNT_AUTHORITY", joinColumns = {
			@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "AUTHORITY_ID") })
	private List<Authority> authorities;
	
	public Account() {
	}
	
	public Account(String username, String password, 
			String firstName, String lastName, int avatar) {
		//setAccount_id(account_id);
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setAvatar(avatar);
		setActivePeriod(0);
	}

	public static final String getLastCustumer() {
		return lastCustumer;
	}

	public static final void setLastCustumer(String lastCustumer) {
		Account.lastCustumer = lastCustumer;
	}

	public final int getAccount_id() {
		return account_id;
	}

	public final void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final int getActivePeriod() {
		return activePeriod;
	}

	public final void setActivePeriod(int activePeriod) {
		this.activePeriod = activePeriod;
	}

	public final int getAvatar() {
		return avatar;
	}

	public final void setAvatar(int avatar) {
		this.avatar = avatar;
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
