package org.jwd.gamenight.controller.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jwd.gamenight.entity.account.Account;
import org.jwd.gamenight.services.account.AccountService;
import org.jwd.gamenight.services.game.GameService;
import org.jwd.gamenight.services.game.GameVoteService;
import org.jwd.gamenight.utils.UserUtils;

@Controller
public class GameRequestController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameVoteService gameVoteService;
	
	@RequestMapping(value = "addOrUpdateUserVote", method = RequestMethod.POST)
	public @ResponseBody String addOrUpdateUserVote(HttpServletRequest request, HttpServletResponse response) {
		String username = UserUtils.getUser().getUsername();
		
		Account thisAccount = accountService.getUserAccountInfo(username);
		int accountId = thisAccount.getAccount_id();
		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		int value = Integer.parseInt(request.getParameter("value"));
		
		int res = gameVoteService.setOrUpdateGameVote(gameId, accountId, value);
		
		return Integer.toString(res);
	}
	
	@RequestMapping(value = "editGame", method = RequestMethod.POST)
	public @ResponseBody String editGame(HttpServletRequest request, HttpServletResponse response) {		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		String res = gameService.updateGameFields(gameId, title, description);
		
		return res;
	}
	
	@RequestMapping(value = "deleteGame", method = RequestMethod.POST)
	public @ResponseBody String deleteGame(HttpServletRequest request, HttpServletResponse response) {
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		
		String res = gameService.deleteGame(gameId);
		
		return res;
	}
}
