package org.myrest.message.service;

import java.util.List;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.myrest.message.DAO.UserDAO;
import org.myrest.message.model.Error;
import org.myrest.message.model.Login;
import org.myrest.message.model.User;


public class UserAuthService {

	private UserDAO dao= new UserDAO();
	
	public Response loginAuth(Login user) {
		User usr=dao.validateLogin(user);
		
		if(PasswordEncrypt.authPassword(user.getPassword(), usr.getPassword())) {
			usr.setStatus("ok");
			return Response.status(Status.OK)
					.entity(usr)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		Error err= new Error();
		err.setStatus("error");
		err.setMessage("Invalid email /or Password.");
		return Response.status(Status.UNAUTHORIZED)
				.entity(err)
				.type(MediaType.APPLICATION_JSON)
				.build();

	}
	
	public Response signupAuth(User user){
		
		String hash= PasswordEncrypt.hashPassword(user.getPassword());
		User usr= dao.addUser(user,hash);
		if(usr==null) {
			Error err= new Error();
			err.setStatus("error");
			err.setMessage(user.getUser_email()+" already exists.");
			return Response.status(Status.BAD_REQUEST)
					.entity(err)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}else {
			usr.setStatus("ok");
			return Response.status(Status.CREATED)
					.entity(usr)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

	}
	
	public List<User> geUsers(){
		return dao.getAllUsers();
	}
}
