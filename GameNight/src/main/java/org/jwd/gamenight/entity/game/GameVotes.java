package org.jwd.gamenight.entity.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_VOTES")
public class GameVotes {

	@Id
	@Column( name = "ACCOUNT_ID" )
	private int account;
	
	@Column( name = "GAME_ID" )
	private int game;
	
	@Column( name = "VALUE" )
	private int value;

	public GameVotes() {
	}
	
	public GameVotes(int account, int game, int value) {
		setAccount(account);
		setGame(game);
		setValue(value);
	}
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public final int getGame() {
		return game;
	}

	public final void setGame(int game) {
		this.game = game;
	}

	public final int getValue() {
		return value;
	}

	public final void setValue(int value) {
		this.value = value;
	}
}
