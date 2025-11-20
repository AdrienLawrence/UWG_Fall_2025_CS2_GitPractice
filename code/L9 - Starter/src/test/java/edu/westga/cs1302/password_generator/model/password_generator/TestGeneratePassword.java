package edu.westga.cs1302.password_generator.model.password_generator;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;

class TestGeneratePassword {

	@Test
	void testMinimumLength1NoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(1);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(false);
		
		String result = generator.generatePassword();
		assertTrue(1 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3NoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(false);
		
		String result = generator.generatePassword();

		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(true);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(false);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneDigitNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(true);
		generator.setMustHaveAtLeastOneDigit(false);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneUpperCaseLetterNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(true);
		generator.setMustHaveAtLeastOneLowerCaseLetter(true);
		generator.setMustHaveAtLeastOneDigit(false);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneDigitNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(false);
		generator.setMustHaveAtLeastOneLowerCaseLetter(true);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneDigitNoOtherRestriction() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(true);
		generator.setMustHaveAtLeastOneLowerCaseLetter(false);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneLowerCaseLetterAtLeastOneDigit() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(3);
		generator.setMustHaveAtLeastOneUpperCaseLetter(true);
		generator.setMustHaveAtLeastOneLowerCaseLetter(true);
		generator.setMustHaveAtLeastOneDigit(true);
		
		String result = generator.generatePassword();
		
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

}
