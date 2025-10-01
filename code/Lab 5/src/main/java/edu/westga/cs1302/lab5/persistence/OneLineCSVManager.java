package edu.westga.cs1302.lab5.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.lab5.model.Student;

/**
 * Class for using the new One-Line CSV format. This class is accessed by MainWindow for usage
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class OneLineCSVManager extends StudentDataPersistenceManager {

	@Override
	public void saveStudentData(Student[] students) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION)) {
			for (Student currStudent : students) {
				writer.write(currStudent.getName() + "," + currStudent.getGrade() + System.lineSeparator());
			}
		}
	}
	
	@Override
	public Student[] loadStudentData() throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(StudentDataPersistenceManager.FILE_LOCATION);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] parts = line.split(",");
				if (parts.length != 2) {
					throw new IOException("Invalid CSV format for " + line);
				}
				String name = parts[0];
				int grade = Integer.parseInt(parts[1]);
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
}
