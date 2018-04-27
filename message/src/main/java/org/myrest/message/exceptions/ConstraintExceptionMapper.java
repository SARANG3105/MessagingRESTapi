package org.myrest.message.exceptions;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import org.myrest.message.model.Error;



@Provider
public class ConstraintExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException arg0) {
		System.out.println("in Exception");
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(arg0))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	  private Error prepareMessage(ConstraintViolationException exception) {
	      Error err =new Error();
	      String msg="";
	      Set<ConstraintViolation<?>> cv =exception.getConstraintViolations();
	         ArrayList<ConstraintViolation<?>> val= new ArrayList<>(cv);
	   msg= val.get(0).getMessage().toString();
	    err.setMessage(msg);
	    err.setStatus("Failed");
	      return err;
	  }

}
