package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.persistence.OneLineCSVManager;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;
import edu.westga.cs1302.lab5.model.Student;

class TestLoadStudentData {
	

	//Copied Tests from CoPilot
	@Test
    void testLoadStudentDataReadsCorrectCsvFormat() throws IOException {
        FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION);
        writer.write("Alice,90\n");
        writer.write("Bob,85\n");
        writer.close();

        OneLineCSVManager manager = new OneLineCSVManager();
        Student[] students = manager.loadStudentData();

        assertEquals(2, students.length);
        assertEquals("Alice", students[0].getName());
        assertEquals(90, students[0].getGrade());
        assertEquals("Bob", students[1].getName());
        assertEquals(85, students[1].getGrade());
    }

    @Test
    void testLoadStudentDataWithInvalidCsvFormatThrowsException() throws IOException {
        FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION);
        writer.write("Alice-90\n"); // Invalid format (missing comma)
        writer.close();

        OneLineCSVManager manager = new OneLineCSVManager();

        assertThrows(IOException.class, () -> {
            manager.loadStudentData();
        });
    }

    @Test
    void testLoadStudentDataWithNonIntegerGradeThrowsException() throws IOException {
        FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION);
        writer.write("Alice,ninety\n"); // Invalid grade
        writer.close();

        OneLineCSVManager manager = new OneLineCSVManager();

        assertThrows(IOException.class, () -> {
            manager.loadStudentData();
        });
        
    }



	  @Test
	  void testLoadStudentDataWithMissingGradeThrowsException() throws IOException {
		  FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION);
		  writer.write("bob,\n"); // Missing grade
		  writer.close();

		  OneLineCSVManager manager = new OneLineCSVManager();

		  assertThrows(IOException.class, () -> {
			  manager.loadStudentData();
	    	});
	    }

	    @Test
	    void testLoadStudentDataWithExtraValuesThrowsException() throws IOException {
	    	FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION);
	    	writer.write("bob,83,84\n"); // Too many values
	    	writer.close();

	    	OneLineCSVManager manager = new OneLineCSVManager();

	    	assertThrows(IOException.class, () -> {
	    		manager.loadStudentData();
	    	});
	    }
}
