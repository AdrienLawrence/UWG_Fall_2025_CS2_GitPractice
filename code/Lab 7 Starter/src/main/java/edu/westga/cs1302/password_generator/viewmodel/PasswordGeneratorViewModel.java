package edu.westga.cs1302.password_generator.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * ViewModel for the Password Generator application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PasswordGeneratorViewModel {
    
    private final IntegerProperty minimumLength;
    private final BooleanProperty mustIncludeDigits;
    private final BooleanProperty mustIncludeLowerCaseLetters;
    private final BooleanProperty mustIncludeUpperCaseLetters;
    private final ReadOnlyStringWrapper generatedPassword;
    private final ReadOnlyStringWrapper errorMessage;
    
    /**
     * Creates a new PasswordGeneratorViewModel.
     * 
     * @precondition none
     * @postcondition all properties are initialized with default values
     */
    public PasswordGeneratorViewModel() {
        this.minimumLength = new SimpleIntegerProperty(1);
        this.mustIncludeDigits = new SimpleBooleanProperty(false);
        this.mustIncludeLowerCaseLetters = new SimpleBooleanProperty(false);
        this.mustIncludeUpperCaseLetters = new SimpleBooleanProperty(false);
        this.generatedPassword = new ReadOnlyStringWrapper("");
        this.errorMessage = new ReadOnlyStringWrapper("");
    }
    
    
    /**
     * Gets the minimum length attribute
     * 
     * @return the minimum length attribute
     */
    public IntegerProperty minimumLengthProperty() {
        return this.minimumLength;
    }
    
    /**
     * Gets the must include digits attribute
     * 
     * @return the must include digits attribute
     */
    public BooleanProperty mustIncludeDigitsProperty() {
        return this.mustIncludeDigits;
    }
    
    /**
     * Gets the must include lower case letters attribute
     * 
     * @return the must include lower case letters attribute
     */
    public BooleanProperty mustIncludeLowerCaseLettersProperty() {
        return this.mustIncludeLowerCaseLetters;
    }
    
    /**
     * Gets the must include upper case letters attribute
     * 
     * @return the must include upper case letters attribute
     */
    public BooleanProperty mustIncludeUpperCaseLettersProperty() {
        return this.mustIncludeUpperCaseLetters;
    }
    
    /**
     * Gets the generated password 
     * 
     * @return the generated password 
     */
    public ReadOnlyStringProperty generatedPasswordProperty() {
        return this.generatedPassword.getReadOnlyProperty();
    }
    
    /**
     * Gets the error message if applicable
     * 
     * @return the error message 
     */
    public ReadOnlyStringProperty errorMessageProperty() {
        return this.errorMessage.getReadOnlyProperty();
    }

    /**
     * Gets the minimum length
     * 
     * @return the minimum length
     */
    public int getMinimumLength() {
        return this.minimumLength.get();
    }
    
    /**
     * Sets the minimum length
     * 
     * @param length the minimum length
     */
    public void setMinimumLength(int length) {
        this.minimumLength.set(length);
    }
    
    /**
     * Gets whether must include digits
     * 
     * @return true if must include digits, false otherwise
     */
    public boolean getMustIncludeDigits() {
        return this.mustIncludeDigits.get();
    }
    
    /**
     * Sets whether password must include digits
     * 
     * @param value true if passwprd must include digits, false otherwise
     */
    public void setMustIncludeDigits(boolean value) {
        this.mustIncludeDigits.set(value);
    }
    
    /**
     * Gets whether password must include lower case letters
     * 
     * @return true if password must include lower case letters, false otherwise
     */
    public boolean getMustIncludeLowerCaseLetters() {
        return this.mustIncludeLowerCaseLetters.get();
    }
    
    /**
     * Sets whether password must include lower case letters
     * 
     * @param value true if must include lower case letters, false otherwise
     */
    public void setMustIncludeLowerCaseLetters(boolean value) {
        this.mustIncludeLowerCaseLetters.set(value);
    }
    
    /**
     * Gets whether password must include upper case letters
     * 
     * @return true if must include upper case letters, false otherwise
     */
    public boolean getMustIncludeUpperCaseLetters() {
        return this.mustIncludeUpperCaseLetters.get();
    }
    
    /**
     * Sets whether password must include upper case letters
     * 
     * @param value true if must include upper case letters, false otherwise
     */
    public void setMustIncludeUpperCaseLetters(boolean value) {
        this.mustIncludeUpperCaseLetters.set(value);
    }
    
    /**
     * Gets the generated password.
     * 
     * @return the generated password
     */
    public String getGeneratedPassword() {
        return this.generatedPassword.get();
    }
    
    /**
     * Gets the error message if applicable
     * 
     * @return the error message
     */
    public String getErrorMessage() {
        return this.errorMessage.get();
    }
    
    
    /**
     * Sets the generated password
     * 
     * @param password the generated password
     */
    public void setGeneratedPassword(String password) {
        this.generatedPassword.set(password);
    }
    
    /**
     * Sets the error message 
     * 
     * @param message the error message
     */
    public void setErrorMessage(String message) {
        this.errorMessage.set(message);
    }
    
    /**
     * Clears any error messages
     * 
     * @precondition none
     * @postcondition errorMessage is cleared
     */
    public void clearError() {
        this.errorMessage.set("");
    }
    
    /**
     * Validates the current settings
     * 
     * @return true if settings are valid, false otherwise
     */
    public boolean validateSettings() {
        if (this.minimumLength.get() < 1) {
            this.errorMessage.set("Invalid Minimum Length: must be at least 1");
            return false;
        }
        this.clearError();
        return true;
    }
}