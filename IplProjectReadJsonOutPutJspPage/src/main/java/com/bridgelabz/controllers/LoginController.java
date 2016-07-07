package com.bridgelabz.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;
import javax.validation.Valid;

import com.bridgelabz.form.LoginForm;
import com.bridgelabz.service.*;


@Controller
@RequestMapping("loginform.html")
public class LoginController {

	//the @Autowired annotation tells Spring where an injection needs to occur.
	@Autowired
	public LoginService loginService;
	/* here matching with respective url pattern and open their respective view pages*/ 
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result
			) {
		// here if the user name and password not matched generate errors in login form page
		if (result.hasErrors()) {
			return "loginform";
		}
		// checking if the user name exist in data base generate error message otherwise stored in database
		boolean userExists = loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
		if(userExists){
			return "loginsuccess";
		}else{
			result.rejectValue("userName","invaliduser");
			return "loginform";
		}
	}

}
