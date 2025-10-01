package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Copied from CoPilot
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.OneLineCSVManager;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;


class TestSaveStudentData {

//Copied tests from CoPilot
	@Test
	void testSaveStudentDataWritesCorrectCsvFormat() throws IOException {
		Student[] students = {
				new Student("Alice", 90),
				new Student("Bob", 85)
		};

		OneLineCSVManager manager = new OneLineCSVManager();
		manager.saveStudentData(students);

		File file = new File(StudentDataPersistenceManager.FILE_LOCATION);
		Scanner scanner = new Scanner(file);

		assertEquals("Alice,90", scanner.nextLine());
		assertEquals("Bob,85", scanner.nextLine());

		scanner.close();
	}
	

	@Test
    void testSaveStudentDataWithEmptyArrayWritesNothing() throws IOException {
        Student[] students = {};

        OneLineCSVManager manager = new OneLineCSVManager();
        manager.saveStudentData(students);

        File file = new File(StudentDataPersistenceManager.FILE_LOCATION);
        Scanner scanner = new Scanner(file);

        assertFalse(scanner.hasNextLine(), "File should be empty for empty student array");

        scanner.close();
    }

    @Test
    void testSaveStudentDataWithNullThrowsException() {
        OneLineCSVManager manager = new OneLineCSVManager();

        assertThrows(IllegalArgumentException.class, () -> {
            manager.saveStudentData(null);
        });
    }
    




}
