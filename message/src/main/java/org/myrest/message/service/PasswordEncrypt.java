package org.myrest.message.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypt {

	public static String hashPassword(String pass) {
		String salt= BCrypt.gensalt();
		return BCrypt.hashpw(pass, salt);
	}
	
	public static boolean authPassword(String plainPassword, String hashPass) {
		if (null == hashPass || !hashPass.startsWith("$2a$")) {
            throw new RuntimeException("Hashed password is invalid");
        }

        return BCrypt.checkpw(plainPassword, hashPass);
    }
	}

