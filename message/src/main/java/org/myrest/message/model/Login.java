package org.myrest.message.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login implements Serializable{
	
	
	@NotNull
	@NotEmpty
	private String email;
	
	@Size(min=6,message="Invalid username/or password.")
	private String password;
	
	public Login() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + email + ", password=" + password + "]";
	}
	
	
}
