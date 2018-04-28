package org.myrest.message.model;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token {

	private static String apiKey="sample";
	public Token() {
		
	}
	public static String getToken(String firstName, String lastName, int id) {
		
		Calendar c = Calendar.getInstance();

		c.setTime(new Date()); // Now use today date.

		c.add(Calendar.DATE, 15);
		SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
		Date date = new Date();
		
		byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary(apiKey);
		
		Key signingKey= new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		JwtBuilder builder= Jwts.builder().setId(String.valueOf(id))
				.setIssuedAt(date)
				.setIssuer(firstName)
				.setExpiration(c.getTime())
				.signWith(signatureAlgorithm, signingKey);
		return builder.compact();
	}
	
	public static Claims parseJWT(String jwt) {
		
		Claims claims= Jwts.parser().setSigningKey( DatatypeConverter.parseBase64Binary(apiKey))
				.parseClaimsJws(jwt).getBody();
		
		return claims;
	}

}
