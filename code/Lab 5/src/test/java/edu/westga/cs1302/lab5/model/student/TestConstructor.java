package edu.westga.cs1302.lab5.model.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Student(null, 88);});
	}

	@Test
	void testNameTooShort() {
		assertThrows(IllegalArgumentException.class, ()->{new Student("12", 87);});
	}
	
	@Test
	void testMinimumLengthName() {
		Student result = new Student("123", 86);
		
		assertEquals("123", result.getName(), "checking the name of the student");
		assertEquals(86, result.getGrade(), "checking the grade for the student");
	}

}
