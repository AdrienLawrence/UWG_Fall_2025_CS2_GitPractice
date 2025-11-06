package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/** 
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
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
    private TextArea output;
    
    @FXML
    private Button generatePasswordButton;
    
    private PasswordGeneratorViewModel viewModel;

    @FXML
    void initialize() {
        this.viewModel = new PasswordGeneratorViewModel();
        this.bindControls();
    }
    
    private void bindControls() {
        
        this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewModel.mustIncludeDigitsProperty());
        this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.viewModel.mustIncludeLowerCaseLettersProperty());
        this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.viewModel.mustIncludeUpperCaseLettersProperty());
        
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(this.minimumLength.textProperty(), this.viewModel.minimumLengthProperty(), converter);
        
        this.output.textProperty().bind(this.viewModel.generatedPasswordProperty());
        
        this.generatePasswordButton.setOnAction(event -> this.viewModel.generatePassword());
    }
}