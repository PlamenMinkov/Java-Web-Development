package org.jwd.gamenight.services.game;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.jwd.gamenight.dao.account.AccountDao;
import org.jwd.gamenight.dao.game.GameDao;
import org.jwd.gamenight.entity.account.Account;
import org.jwd.gamenight.entity.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private AccountDao accountDao;
	
	private HashMap<Integer, Account> accounts;
	private List<Account> accountsList = new ArrayList<>();
	
	@Override
	public List<Game> getAllGames() {
		return gameDao.getGames();
	}

	@Override
	public Game getGameData(String title) {
		return gameDao.getGame(title);
	}

	@Override
	public String updateGameFields(int gameId, String title, String description) {
		
		return gameDao.updateGameFields(gameId, title, description);
	}

	@Override
	public void createGame(String title, String description, String username) {
		Account author = accountDao.getAccount(username);
		
		int authorId = author.getAccount_id();
		
		gameDao.addGame(new Game(title, description, authorId));
	}

	@Override
	public List<Game> getGamesByAuthor(String author) {
		Account account = accountDao.getAccount(author);
		int authorId = account.getAccount_id();
		
		return gameDao.getGamesByAuthorId(authorId);
	}

	@Override
	public String deleteGame(int gameId) {
		
		return gameDao.deleteGame(gameId);
	}

}
