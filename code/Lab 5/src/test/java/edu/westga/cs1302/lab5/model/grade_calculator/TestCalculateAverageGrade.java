package edu.westga.cs1302.lab5.model.grade_calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.TestingConstants;
import edu.westga.cs1302.lab5.model.GradeCalculator;
import edu.westga.cs1302.lab5.model.Student;

class TestCalculateAverageGrade {

	@Test
	void testNullStudents() {
		assertThrows(IllegalArgumentException.class, ()->{GradeCalculator.calculateAverageGrade(null);});
	}

	@Test
	void testNoStudent() {
		ArrayList<Student> students = new ArrayList<Student>();

		assertThrows(IllegalArgumentException.class, ()->{GradeCalculator.calculateAverageGrade(students);});
	}

	@Test
	void testOneStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("aaa", 1));
		
		double result = GradeCalculator.calculateAverageGrade(students);
		
		assertEquals(1.0, result, TestingConstants.DELTA);
	}

	@Test
	void testMultipleStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("aaa", 1));
		students.add(new Student("bbb", 2));
		
		double result = GradeCalculator.calculateAverageGrade(students);
		
		assertEquals(1.5, result, TestingConstants.DELTA);
	}

}
