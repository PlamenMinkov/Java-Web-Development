package org.jwd.gamenight.controller.account;

import org.jwd.gamenight.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("user", UserUtils.getUser());
		
		return "login";
	}
}