package org.jwd.gamenight.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITY")
public class Authority {

	@Id
	@Column(name = "AUTHORITY_ID")
	private long authority_id;

	@Column(name = "AUTHORITY")
	private String authority;

	public long getId() {
		return authority_id;
	}

	public void setId(long id) {
		this.authority_id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
