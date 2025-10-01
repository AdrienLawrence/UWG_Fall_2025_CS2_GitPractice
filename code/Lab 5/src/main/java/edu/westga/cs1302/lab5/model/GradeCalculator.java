package edu.westga.cs1302.lab5.model;

import java.util.List;

/** Provides utility functions for grade calculations.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class GradeCalculator {

	/** Calculates average grade for a set of students.
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the list of students to calculate average grade for
	 * @return average grade 	if !students.isEmpty()
	 * 		   0				if students.isEmpty()
	 */
	public static double calculateAverageGrade(List<Student> students) {
		if (students == null) {
			throw new IllegalArgumentException("no students provided.");
		}
		if (students.size() == 0) {
			throw new IllegalArgumentException("no students provided.");
		}
		int sumGrade = 0;
		for (Student student : students) {
			sumGrade += student.getGrade();
		}
		return sumGrade / ((double) (students.size()));
	}
}
