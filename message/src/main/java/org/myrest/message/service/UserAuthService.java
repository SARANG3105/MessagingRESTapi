package org.myrest.message.service;

import java.util.List;
import javax.inject.Inject;
import org.myrest.message.DAO.UserDAO;
import org.myrest.message.model.User;



public class UserAuthService {


	private UserDAO dao= new UserDAO();
	
	public User loginAuth() {
		User user= new User();
		
		
		
		return user;
	}
	public User signupAuth(User user) {
		
		return dao.addUser(user);
	
		
	}
	public List<User> geUsers(){
		return dao.getAllUsers();
	}
}
