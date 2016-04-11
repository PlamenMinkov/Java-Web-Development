package org.jwd.gamenight.entity.game;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;

@Entity
@Table(name="GAME")
public class Game implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "GAME_ID" )
	private int gameId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "VOTE")
	private int vote;
	
	@Column(name = "AUTHOR_ID")
	private int authorId;
	
	public Game() {
	}
	
	public Game(String title, String despcription, int authorId) {
		setTitle(title);
		setDescription(despcription);
		setAuthorId(authorId);
		this.vote = 0;
	}

	public final int getGameId() {
		return gameId;
	}

	public final void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final int getVote() {
		return vote;
	}

	public final void setVote(int vote) {
		this.vote += vote;
	}

	public final int getAuthorId() {
		return authorId;
	}

	public final void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
}
