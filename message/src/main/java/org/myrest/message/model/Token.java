package org.myrest.message.model;

import java.util.UUID;

public class Token {

	public Token() {
		
	}
	public static String getToken(String firstName, String lastName) {
		
		UUID id= UUID.randomUUID();
		
		return (String.valueOf(id));
	}

}
