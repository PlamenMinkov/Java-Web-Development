package org.jwd.gamenight.services.game;

import org.jwd.gamenight.dao.game.GameVoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameVoteServiceImpl implements GameVoteService{
	@Autowired
	private GameVoteDao gameVoteDao;
	
	@Override
	public int setOrUpdateGameVote(int gameId, int accountId, int value) {
		
		return gameVoteDao.setOrUpdateGameVote(gameId, accountId, value);
	}
}
