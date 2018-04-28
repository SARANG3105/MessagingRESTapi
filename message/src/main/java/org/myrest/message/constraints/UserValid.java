package org.myrest.message.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.myrest.message.model.User;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValid.Validator.class)
public @interface UserValid {
	  
	public class Validator implements ConstraintValidator<UserValid, User>{

		@Override
		public boolean isValid(User value, ConstraintValidatorContext context) {
			if(value.getPassword().length()>6) {
				System.out.println(""+value.getPassword());
				return true;
			}
			return false;
		}
		
	}

}
