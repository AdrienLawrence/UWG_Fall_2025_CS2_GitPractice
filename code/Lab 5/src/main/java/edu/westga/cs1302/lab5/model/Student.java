package edu.westga.cs1302.lab5.model;

/** Stores and manages information for a single student.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Student {
	private String name;
	private int grade;
	
	/** Create a new student with the specified name
	 * 
	 * @precondition name != null && name.length() >= 3
	 * @postcondition getName() == name
	 * 
	 * @param name the name of the new student
	 * @param grade the grade for the new student
	 * 
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public Student(String name, int grade) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Name must be provided.");
		}
		if (name.length() < 3) {
			throw new IllegalArgumentException("Name must have at least 3 characters.");
		}
		this.name = name;
		this.grade = grade;
	}
	
	/** Return the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}
	
	/** Returns the grade for the student
	 * 
	 * @return the grade for the student
	 */
	public int getGrade() {
		return this.grade;
	}
	
	@Override
	public String toString() {
		return this.name +  " - " + this.grade;
	}
	
}
