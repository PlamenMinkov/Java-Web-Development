package org.jwd.bank.controllers;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.jwd.bank.beans.*;
import org.jwd.bank.constants.UrlConstants;
import org.jwd.bank.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {	
	@Autowired
	private Operation operationBean;
	
	@Autowired
	private Validator validatorBean;
	
	@Autowired
	//@Qualifier("firstImpl")
	private Account acountBean;
	
	@RequestMapping(value=UrlConstants.CUSTOMERS_REGISTER_URL, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("customers", acountBean.getAllCustomers() );
		
		model.addAttribute("bankOperationUrl", UrlConstants.BANK_OPPERATIONS_URL );
		
		return "customersRegister";
	}
	
	@RequestMapping(value=UrlConstants.BANK_OPPERATIONS_URL, method = RequestMethod.GET)
	public String addStudent(Model model) {
		String lastCustomerName = Customers.getLastCustumer();
		String customerName = null;
		double accountAmount = 0;
		
		if(lastCustomerName != null) {
			Customers lastCustomer = acountBean.getUserAccountInfo(lastCustomerName);
			
			customerName = lastCustomer.getName();
			accountAmount = lastCustomer.getAccountAmount();
		}
		
		model.addAttribute("customerName", customerName);
		model.addAttribute("accountAmount", accountAmount);
		
		model.addAttribute("saveOperation", UrlConstants.BANK_OPPERATIONS_SAVE_URL);
		
		return "bank";
	}
	
	@RequestMapping(value=UrlConstants.BANK_OPPERATIONS_SAVE_URL, method = RequestMethod.POST)
	public String addStudentSave(Model model, HttpServletRequest request) {
		/*HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.getSession().setAttribute("username", requestUsername);*/
		
		model.addAttribute("customers", acountBean.getAllCustomers() );
		
		String name = request.getParameter("name");
		String operation = request.getParameter("operation");
		double amount = Double.parseDouble(request.getParameter("amount"));
		double sum = Double.parseDouble(request.getParameter("sum"));
		
		String message = validatorBean.validateOperationsData(name, amount, sum, operation);		
		request.setAttribute("message", message);
		
		if(!message.equals("true")) {
			model.addAttribute("message", message);
			
			return addStudent(model);
		}
		else {
			if(operation.equals("deposit")) {
				operationBean.deposit(name, sum, "EUR");
			}
			else {
				operationBean.withdraw(name, sum, "EURO");
			}
		}
		
		return "redirect:/customersRegister";
	}
}
