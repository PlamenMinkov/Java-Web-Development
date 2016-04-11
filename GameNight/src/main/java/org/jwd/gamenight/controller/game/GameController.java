package org.jwd.gamenight.controller.game;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.jwd.gamenight.constants.UrlConstants;
import org.jwd.gamenight.entity.game.Game;
import org.jwd.gamenight.services.game.GameService;
import org.jwd.gamenight.utils.UserUtils;

@Controller
public class GameController {
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value=UrlConstants.GAME_REGISTER_URL, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		model.addAttribute("games", gameService.getAllGames());
		
		model.addAttribute("createGameUrl", UrlConstants.CREATE_GAME_URL );
		model.addAttribute("user", UserUtils.getUser());
		model.addAttribute("title", "Игри");
		
		return "game/gameRegister";
	}
	
	@RequestMapping(value=UrlConstants.CREATE_GAME_URL, method = RequestMethod.GET)
	public String addStudent(Model model) {		
		model.addAttribute("saveGame", UrlConstants.CREATE_GAME_SAVE_URL);
		model.addAttribute("user", UserUtils.getUser());
		
		return "game/createGame";
	}
	
	@RequestMapping(value=UrlConstants.CREATE_GAME_SAVE_URL, method = RequestMethod.POST)
	public String addStudentSave(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("games", gameService.getAllGames() );
		model.addAttribute("user", UserUtils.getUser());
		
		String username = UserUtils.getUser().getUsername();
		
		gameService.createGame(request.getParameter("title"), request.getParameter("description"), username);
		
		return "redirect:/gameRegister";
	}
	
	@RequestMapping(value=UrlConstants.EDIT_OWN_GAME_URL, method = RequestMethod.GET)
	public String editOwnGame(Model model) {		
		model.addAttribute("user", UserUtils.getUser());
		
		String username = UserUtils.getUser().getUsername();
		
		List<Game> games = gameService.getGamesByAuthor(username);
		System.out.println(games.size());
		
		for (Game game : games) {
			System.out.println(game.getTitle());
			System.out.println(game.getGameId());
			System.out.println();
		}
		
		model.addAttribute("games", gameService.getGamesByAuthor(username));
		
		return "game/editDeleteOwnGame";
	}
}
