package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.TaskUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/** Controller class for MainWindow of the Task Tracker system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private TextArea description;
    @FXML private Label highCount;
    @FXML private Label lowCount;
    @FXML private Label mediumCount;
    @FXML private TextField name;
    @FXML private ComboBox<TaskPriority> priority;
    @FXML private TextArea selectedDescription;
    @FXML private TextField selectedPriority;
    @FXML private ListView<Task> tasks;
    @FXML private ComboBox<Comparator<Task>> order;
    
    @FXML 
    void addTask(ActionEvent event) {
    	try {
    		this.tasks.getItems().add(new Task(this.name.getText(), this.description.getText(), this.priority.getValue()));
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }

    @FXML
    void selectTask(MouseEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.selectedPriority.setText(selectedTask.getPriority().toString());
    		this.selectedDescription.setText(selectedTask.getDescription());
    	}
    }

    @FXML
    void removeTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.tasks.getItems().remove(selectedTask);
    	}
    }

    @FXML
    void updateDescription(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		selectedTask.setDescription(this.selectedDescription.getText());
    	}
    }

    @FXML
    void countPriorities(ActionEvent event) {
    	this.highCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.HIGH, this.tasks.getItems())));
    	this.mediumCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.MEDIUM, this.tasks.getItems())));
    	this.lowCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.LOW, this.tasks.getItems())));
    }
    
    @FXML
    void sortTasks(ActionEvent event) {

    }

    /** Perform any needed initialization of UI components and underlying objects.
     * 
     */
    public void initialize() {
    	this.priority.getItems().addAll(TaskPriority.HIGH, TaskPriority.MEDIUM, TaskPriority.LOW);
    	this.priority.setValue(this.priority.getItems().get(0));
    }
}
