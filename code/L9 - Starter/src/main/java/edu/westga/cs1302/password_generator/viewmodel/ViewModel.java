package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {
	private StringProperty minimumLength;
	private BooleanProperty requireDigits;
	private BooleanProperty requireLowercase;
	private BooleanProperty requireUppercase;
	
	private ListProperty<String> passwordHistory;
	private StringProperty errorText;
	
    private PasswordGenerator generator;
	
	/** Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.minimumLength = new SimpleStringProperty("1");
		this.requireDigits = new SimpleBooleanProperty(false);
		this.requireLowercase = new SimpleBooleanProperty(false);
		this.requireUppercase = new SimpleBooleanProperty(false);
		
		this.passwordHistory = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
		this.errorText = new SimpleStringProperty("");

        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
	}

	/** Return the minimum length property
	 * 
	 * @return the minimum length property
	 */
	public StringProperty getMinimumLength() {
		return this.minimumLength;
	}

	/** Return the require digits property
	 * 
	 * @return the require digits property
	 */
	public BooleanProperty getRequireDigits() {
		return this.requireDigits;
	}

	/** Return the require upper case property
	 * 
	 * @return the require upper case property
	 */
	public BooleanProperty getRequireUppercase() {
		return this.requireUppercase;
	}

	/** Return the require lower case property
	 * 
	 * @return the require lower case property
	 */
	public BooleanProperty getRequireLowercase() {
		return this.requireLowercase;
	}

	/** Return the password property
	 * 
	 * @return the password property
	 */
	public ListProperty<String> getPasswordHistory() {
		return this.passwordHistory;
	}
	
	/** Return the password history as an observable list
	 * 
	 * @return the password history list
	 */
	public ObservableList<String> getPasswordHistoryList() {
		return this.passwordHistory.get();
	}

	/** Return the error text property
	 * 
	 * @return the error text property
	 */
	public StringProperty getErrorText() {
		return this.errorText;
	}

	/** Generates a password using the minimum length, require digit, require lower case, and require upper case property values.
	 * 
	 * If a password is successfully generated, the error text property is set to empty string and the password property is set to the password generated.
	 * 
	 * If an error is encountered, the password property is set to empty, and the error text property is populated with a message describing the problem.
	 */
	public void generatePassword() {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLength.getValue());
    	} catch (NumberFormatException numberError) {
    		this.errorText.setValue("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getValue());
    		return;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		this.errorText.setValue("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		return;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.requireDigits.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.requireLowercase.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.requireUppercase.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.passwordHistory.add(password);
    	this.errorText.setValue("");
    }
    
    /**
     * Saves the password history to the specified file path
     * 
     * @param filePath the full file path to save to
     * @return empty string if successful, error message if failed
     */
    public String savePasswordsToFile(String filePath) {
    	if (filePath == null || filePath.trim().isEmpty()) {
    		return "No file selected";
    	}
    	
    	File file = new File(filePath);
    	try (FileWriter writer = new FileWriter(file)) {
    		for (String password : this.passwordHistory.get()) {
    			writer.write(password + System.lineSeparator());
    		}
    		return "";
    	} catch (IOException exception) {
    		return "Error saving file: " + exception.getMessage();
    	}
    }
}