package org.jwd.gamenight.controller.account;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jwd.gamenight.constants.UrlConstants;
import org.jwd.gamenight.dao.account.AccountDao;
import org.jwd.gamenight.entity.account.Account;
import org.jwd.gamenight.services.account.*;
import org.jwd.gamenight.utils.UserUtils;

@Controller
public class AccountRequestController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "addActivePeriod", method = RequestMethod.POST)
	public @ResponseBody String addPeriod(HttpServletRequest request, HttpServletResponse response) {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		
		int newActivePeriod = accountService.addActivePeriod(accountId);
		
		return Integer.toString(newActivePeriod);
	}
}
