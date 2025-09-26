package edu.westga.cs1302.project1.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import edu.westga.cs1302.project1.model.Task;
import javafx.scene.control.Label;
import edu.westga.cs1302.project1.model.PriorityCounter;

import java.util.List;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML
    private TextArea descField;

    @FXML
    private Text descLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Text nameLabel;

    @FXML
    private ComboBox<Integer> prioBox;

    @FXML
    private Text prioLabel;

    @FXML
    private Button subButton;

    @FXML
    private ListView<Task> taskView;

    @FXML
    private TextArea selectDesc;

    @FXML
    private TextField selectPrio;
    
    @FXML
    private Button updateDescButton;
    
    @FXML
    private Button removeButton;
    
    @FXML
    private Label prio1Label;

    @FXML
    private Label prio2Label;

    @FXML
    private Label prio3Label;

    @FXML
    private Label prio4Label;

    @FXML
    private Label prio5Label;
    
    @FXML
    private Button prioCountButton;

    /**
     * Perform any needed initialization of UI components and underlying objects.
     * 
     * Initializes comboBox with priority values 1-5
     * 
     * Note: comboBox has the first option selected by default with selectFirst() 
     * to prevent adding a task with no priority selected which could cause errors
     */
    public void initialize() {
    	this.prioBox.getItems().addAll(1, 2, 3, 4, 5);
    	this.prioBox.getSelectionModel().selectFirst();
    	
    	this.taskView.getSelectionModel().selectedItemProperty().addListener(
    	        (observable, current, select) -> {
    	        	
    	            if (select != null) {
    	             
    	                this.selectDesc.setText(select.getDescription());
    	                this.selectPrio.setText(String.valueOf(select.getPriority()));
    	                
    	            } else {
    	                
    	                this.selectDesc.clear();
    	                this.selectPrio.clear();
    	            }
    	        }
    	    );
    }
    
    @FXML
    void addTask(ActionEvent event) {
    	 
    	 try {
    	 
    		 String name = this.nameField.getText();
    		 String desc = this.descField.getText();
    		 int prio = this.prioBox.getValue();
    	 
    		 Task task = new Task(name, desc, prio);
    	 
    		 this.taskView.getItems().add(task);
    	 
    		 this.nameField.clear();
    		 this.descField.clear();
    		 this.prioBox.getSelectionModel().selectFirst();
    		
    	 } catch (IllegalArgumentException err) {
    	
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    		 alert.setTitle("Invalid Task");
    		 alert.setHeaderText("Cannot Create Task");
    		 alert.setContentText(err.getMessage());
    		 alert.showAndWait();
    	 }
   
     }
     
     @FXML
     void updateDesc(ActionEvent event) {
    	 
    	 try {
    		 Task select = this.taskView.getSelectionModel().getSelectedItem();
    	 
    		 if (select == null) {
    			 Alert alert = new Alert(Alert.AlertType.WARNING);
    			 alert.setContentText("No Task Selected to Update");
    			 alert.showAndWait();
    			 return;
    		 }
    	 
    		 String newDesc = this.selectDesc.getText().trim();
    	 
    		 select.setDesc(newDesc);
    	 } catch (IllegalArgumentException err) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    		 alert.setContentText(err.getMessage());
    		 alert.showAndWait();
    	 }
     }
     
     @FXML
     void removeTask(ActionEvent event) {
    	 
    	 Task select = this.taskView.getSelectionModel().getSelectedItem();
    	 
    	 if (select == null) {
    		 Alert alert = new Alert(Alert.AlertType.WARNING);
			 alert.setContentText("No Task Selected to Remove");
			 alert.showAndWait();
			 return;
    	 }
    	 
    	 this.taskView.getItems().remove(select);
    	 
    	 this.selectDesc.clear();
    	 this.selectPrio.clear();
    	 
     }

     @FXML
     void showCounts(ActionEvent event) {
    	 try {
    	
    		 List<Task> tasks = this.taskView.getItems();
    		 
    		 int count1 = PriorityCounter.countTasks(1, tasks);
    		 int count2 = PriorityCounter.countTasks(2,  tasks);
    		 int count3 = PriorityCounter.countTasks(3,  tasks);
    		 int count4 = PriorityCounter.countTasks(4,  tasks);
    		 int count5 = PriorityCounter.countTasks(5,  tasks);
    		 
    		 this.prio1Label.setText("1 - Number of Tasks: " + count1);
    		 this.prio2Label.setText("2 - Number of Tasks: " + count2);
    		 this.prio3Label.setText("3 - Number of Tasks: " + count3);
    		 this.prio4Label.setText("4 - Number of Tasks: " + count4);
    		 this.prio5Label.setText("5 - Number of Tasks: " + count5);
    	 } catch (Exception err) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    		 alert.setContentText(err.getMessage());
    		 alert.showAndWait();
    	 }
     }

}


