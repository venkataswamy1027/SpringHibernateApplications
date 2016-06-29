package com.bridgelabz.controllers;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.form.Registration;
import com.bridgelabz.model.Users;
import com.bridgelabz.service.LoginService;

/**
 * @author bridgeit
 *
 */
@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	@Autowired
	public LoginService loginService;
	public void setRegistrationValidation(RegistrationValidation registrationValidation) 
	{
		this.registrationValidation = registrationValidation;
	}
	@Autowired
	private LoginService employeeService;
	@Autowired
	public  RegistrationValidation registrationValidation;
	/* here matching with respective url pattern and open their respective view pages*/ 
	@RequestMapping(method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("registration") @Valid Registration registration, 
			BindingResult result,Map model) {
		// set custom Validation by user
		registrationValidation.validate(registration, result);
		if (result.hasErrors()) 
		{
			return "registrationform";
		}
		// checking if the user email exist in data base generate error message otherwise stored in database
		boolean userEmailExists = loginService.checkEmail(registration.getEmail());
		System.out.println("1");
		if(userEmailExists)
		{
			model.put("registration",registration);
			result.rejectValue("email","invalidemail");
			return "registrationform";
		}
		// checking if the user name exist in data base generate error message otherwise stored in database
		boolean userNameExists = loginService.checkUserName(registration.getUserName());
		System.out.println("1");
		if(userNameExists)
		{
			model.put("registration",registration);
			result.rejectValue("userName","invalidusername");
			return "registrationform";
		}
		else
		{
			//here new student registration data is add to method
			Users user = prepareModel(registration);
			employeeService.addStudent(user);
			return "registrationsuccess";
		}
	}
	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		Registration registration = new Registration();
		model.put("registration", registration);
		return "registrationform";
	}
	//here set ur users class fields to match with registration class fields
	private Users prepareModel(Registration registration){
		Users user = new Users();
		user.setUserName(registration.getUserName());
		user.setUserPassword(registration.getPassword());
		user.setConfirmPassword(registration.getConfirmPassword());
		user.setEmail(registration.getEmail());
		user.setId(null);
		return user;
	}
}
