package org.jwd.gamenight.services.game;

import java.util.HashMap;
import java.util.List;

import org.jwd.gamenight.entity.account.Account;
import org.jwd.gamenight.entity.game.Game;

public interface GameService {
	List<Game> getAllGames();
	
	public Game getGameData(String title);

	public String updateGameFields(int gameId, String title, String description);
	
	public String deleteGame(int gameId);
	
	public void createGame(String title, String description, String username);
	
	public List<Game> getGamesByAuthor(String author);
}
