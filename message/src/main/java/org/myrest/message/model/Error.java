package org.myrest.message.model;

public class Error {
String status;
String message;

public Error() {
	
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
