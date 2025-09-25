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
import javafx.scene.control.Alert;

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
    		
    	 } catch (IllegalArgumentException e) {
    	
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    		 alert.setTitle("Invalid Task");
    		 alert.setHeaderText("Cannot Create Task");
    		 alert.setContentText(e.getMessage());
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
    	 } catch (IllegalArgumentException e) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    		 alert.setContentText(e.getMessage());
    		 alert.showAndWait();
    	 }
     }
}


