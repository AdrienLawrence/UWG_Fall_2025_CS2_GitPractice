package edu.westga.cs1302.lab5.persistence;

import java.io.IOException;
import java.io.FileNotFoundException;

import edu.westga.cs1302.lab5.model.Student;

/** Supports saving and loading student data,
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public abstract class StudentDataPersistenceManager {
	
	public static final String FILE_LOCATION = "data.txt";
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public abstract void saveStudentData(Student[] students) throws IOException, IllegalArgumentException;

	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	public abstract Student[] loadStudentData() throws FileNotFoundException, IOException;
}
