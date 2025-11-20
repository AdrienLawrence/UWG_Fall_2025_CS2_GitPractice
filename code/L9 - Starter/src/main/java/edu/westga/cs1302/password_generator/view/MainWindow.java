package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML 
    private CheckBox mustIncludeDigits;
    
    @FXML 
    private CheckBox mustIncludeLowerCaseLetters;
    
    @FXML 
    private CheckBox mustIncludeUpperCaseLetters;
    
    @FXML 
    private TextField minimumLength;
    
    @FXML 
    private Label errorTextLabel;
    
    @FXML 
    private Label minLengthErrorText;
    
    @FXML 
    private Button generatePasswordButton;
    
    @FXML 
    private ListView<String> passwordHistory;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
    		this.minLengthErrorText.setVisible(!newValue.matches("\\d+") || Integer.parseInt(newValue) == 0);
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    }
    
    /**
     * Handles the Save menu item action
     */
    @FXML
    private void handleSave() {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Save Passwords");
    	fileChooser.getExtensionFilters().add(
    	    new ExtensionFilter("Text Files", "*.txt")
    	);
    	
    	File file = fileChooser.showSaveDialog(this.generatePasswordButton.getScene().getWindow());
    	
    	if (file != null) {
    	    String result = this.vm.savePasswordsToFile(file.getAbsolutePath());
    	    
    	    Alert alert;
    	    if (result.isEmpty()) {
    	        alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("Save Successful");
    	        alert.setContentText("Passwords saved successfully to: " + file.getName());
    	    } else {
    	        alert = new Alert(AlertType.ERROR);
    	        alert.setTitle("Save Error");
    	        alert.setContentText(result);
    	    }
    	    alert.setHeaderText(null);
    	    alert.showAndWait();
    	}
    }
    
    /**
     * Handles the About menu item action
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("About Password Generator");
    	alert.setHeaderText("Password Generator Application");
    	alert.setContentText("Password Generator creates personalized passwords based on giving requirements about length and characters.\n\n"
    	                  + "Author: Adrien Lawrence");
    	
    	alert.showAndWait();
    }
    
    /**
     * Handles the Close menu item action
     */
    @FXML
    private void handleClose() {
    	((javafx.scene.Node) this.generatePasswordButton).getScene().getWindow().hide();
    }
}