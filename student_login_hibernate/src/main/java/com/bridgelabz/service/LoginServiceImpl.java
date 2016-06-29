package com.bridgelabz.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.dao.*;
import com.bridgelabz.model.Users;
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
//The transactional annotation itself defines the scope of a single database transaction
public class LoginServiceImpl implements LoginService {
	//The @Autowired annotation tells Spring where an injection needs to occur.
	 @Autowired
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(userName, userPassword);
       }
       @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
   		public void addStudent(Users user) {
   		loginDAO.addStudent(user);
   	}
       public boolean checkEmail(String email)
       {
    	   return loginDAO.checkEmail(email);
       }
       public boolean checkUserName(String userName)
       {
    	   return loginDAO.checkUserName(userName);
       }
}