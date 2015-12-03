package com.sarker.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements
		ConstraintValidator<IsValidHobby, String> {

	private String listOfHobbies;

	public void initialize(IsValidHobby isValidHobby) {
		this.listOfHobbies = isValidHobby.listOfValidHobbies();
	}

	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if (studentHobby == null) {
			return false;
		}
		if (studentHobby.matches(listOfHobbies)) {
			return true;
		}
		return false;
	}

}
