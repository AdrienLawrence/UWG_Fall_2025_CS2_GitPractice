package edu.westga.cs1302.lab5.views;

import java.io.IOException;

import edu.westga.cs1302.lab5.model.GradeCalculator;
import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.OneLineCSVManager;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	private StudentDataPersistenceManager manager = new OneLineCSVManager();
	
	@FXML private TextField avgGrade;
	@FXML private TextField grade;
	@FXML private TextField name;
    @FXML private ListView<Student> students;

	@FXML
	void addStudent(ActionEvent event) {
		try {
			String name = this.name.getText();
			int grade = Integer.parseInt(this.grade.getText());
			Student student = new Student(name, grade);
			this.students.getItems().add(student);
			this.avgGrade.setText(Double.toString(GradeCalculator.calculateAverageGrade(this.students.getItems())));
		} catch (NumberFormatException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Invalid grade provided, must be an integer value. Please reenter grade.");
			alert.showAndWait();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to generate Student: " + error.getMessage() + ". Please reenter Student information.");
			alert.showAndWait();
		}
	}

	@FXML
	void loadStudents(ActionEvent event) {
		this.loadStudents();
	}

	private void loadStudents() {
		try {
			Student[] students = this.manager.loadStudentData();
			this.students.getItems().clear();
			this.students.getItems().addAll(students);
		} catch (IOException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void saveStudents(ActionEvent event) {
		try {
			this.manager.saveStudentData(this.students.getItems().toArray(new Student[0]));
		} catch (Exception error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {
		this.loadStudents();
	}
}
