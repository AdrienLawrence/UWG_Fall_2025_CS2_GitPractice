package edu.westga.cs1302.project1.views;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import edu.westga.cs1302.project1.model.Task;

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

   
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
    
     @FXML
    void addTask(ActionEvent event) {

    }
}


