package edu.westga.cs1302.password_generator.tests.model.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;

class TestSetMinimumLength {

	@Test
	void testInvalidLength() {
		PasswordGenerator generator = new PasswordGenerator(0);
		
		assertThrows(IllegalArgumentException.class, ()->{generator.setMinimumLength(0);});
	}
	@Test
	void testValidLength() {
		PasswordGenerator generator = new PasswordGenerator(0);
		
		generator.setMinimumLength(1);
		
		assertEquals(1, generator.getMinimumLength(), "checking length");
	}

}
