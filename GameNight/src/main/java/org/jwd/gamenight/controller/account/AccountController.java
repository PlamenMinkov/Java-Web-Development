package org.jwd.gamenight.controller.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.jwd.gamenight.dto.account.UserSearch;

import org.jwd.gamenight.constants.UrlConstants;
import org.jwd.gamenight.services.account.*;
import org.jwd.gamenight.services.game.GameService;
import org.jwd.gamenight.utils.UserUtils;

@Controller
public class AccountController {	
	@Autowired
	private Operation operationService;
	
	@Autowired
	//@Qualifier("firstImpl")
	private AccountService accountService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value=UrlConstants.CUSTOMERS_REGISTER_URL, method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute("UserSearch") UserSearch userSearch) {
		model.addAttribute("customers", accountService.getAccounts(userSearch.getUsername()));
		
		model.addAttribute("accountRegister", UrlConstants.CUSTOMERS_REGISTER_URL );
		model.addAttribute("registrationUrl", UrlConstants.REGISTRATION_URL );
		model.addAttribute("accountProfile", UrlConstants.ACCOUNT_PROFILE_URL );
		model.addAttribute("user", UserUtils.getUser());
		
		return "customersRegister";
	}
	
	@RequestMapping(value=UrlConstants.REGISTRATION_URL, method = RequestMethod.GET)
	public String addStudent(Model model) {		
		model.addAttribute("saveRegistration", UrlConstants.REGISTRATION_SAVE_URL);
		model.addAttribute("user", UserUtils.getUser());
		
		return "registration";
	}
	
	@RequestMapping(value=UrlConstants.REGISTRATION_SAVE_URL, method = RequestMethod.POST)
	public String addStudentSave(Model model, HttpServletRequest request) throws Exception {
		
		model.addAttribute("customers", accountService.getAccounts(null) );
		
		String password = request.getParameter("password");
		
		password = operationService.convertToMD5(password);
		
		accountService.createUserAccountInfo(request.getParameter("username"), password, 
				request.getParameter("firstName"), request.getParameter("lastName"), 0);
		model.addAttribute("user", UserUtils.getUser());
		
		return "redirect:/customersRegister";
	}
	
	@RequestMapping(value=UrlConstants.ACCOUNT_PROFILE_URL, method = RequestMethod.GET)
	public String accountProfile(Model model, @ModelAttribute("UserSearch") UserSearch userSearch) {		
		model.addAttribute("saveRegistration", UrlConstants.REGISTRATION_SAVE_URL);
		model.addAttribute("customers", accountService.getAccounts(userSearch.getUsername()));
		model.addAttribute("games", gameService.getGamesByAuthor(userSearch.getUsername()));		
		model.addAttribute("user", UserUtils.getUser());
		
		return "account/accountProfile";
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpServletRequest request) throws Exception {
		String username = UserUtils.getUser().getUsername();
		
		model.addAttribute("customers", accountService.getAccounts(username));
		model.addAttribute("games", gameService.getGamesByAuthor(username));
		
		model.addAttribute("user", UserUtils.getUser());
		
		return "account/accountProfile";
	}
}
