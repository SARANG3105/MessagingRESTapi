package org.myrest.message;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.json.JsonObject;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.myrest.message.model.User;
import org.myrest.message.service.UserAuthService;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserAuthResource {
	
	
	private UserAuthService service= new UserAuthService();
	
	@POST
	@Path("/login")
	public User loginUser() {
		
		return null;
		
	}
	
	@POST
	@Path("/signup")
	public Response signUp(@Valid User user) throws ConstraintViolationException {
		return service.signupAuth(user);
				
				
	}
	
	@GET
	@Path("/allusers")
	public List<User> getUsers(){
		return service.geUsers();
	}
}
