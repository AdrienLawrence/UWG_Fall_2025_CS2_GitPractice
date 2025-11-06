package edu.westga.cs1302.password_generator.tests.viewmodel.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;

/**
 * Tests for PasswordGeneratorViewModel.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
class TestPasswordGeneratorViewModel {

   
    @Test
    void testDefaultValues() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
   
        assertEquals(1, viewModel.getMinimumLength());
        assertFalse(viewModel.getMustIncludeDigits());
        assertFalse(viewModel.getMustIncludeLowerCaseLetters());
        assertFalse(viewModel.getMustIncludeUpperCaseLetters());
        assertEquals("", viewModel.getGeneratedPassword());
        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    void testPropertySettersAndGetters() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.setMinimumLength(10);
        assertEquals(10, viewModel.getMinimumLength());

        viewModel.setMustIncludeDigits(true);
        assertTrue(viewModel.getMustIncludeDigits());

        viewModel.setMustIncludeLowerCaseLetters(true);
        assertTrue(viewModel.getMustIncludeLowerCaseLetters());

        viewModel.setMustIncludeUpperCaseLetters(true);
        assertTrue(viewModel.getMustIncludeUpperCaseLetters());
    }

    @Test
    void testValidateSettingsWithValidInput() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.setMinimumLength(5);
        
        boolean isValid = viewModel.validateSettings();
        
        assertTrue(isValid);
        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    void testValidateSettingsWithInvalidLength() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
        viewModel.setMinimumLength(0);
        
        boolean isValid = viewModel.validateSettings();
        
        assertFalse(isValid);
        assertEquals("Invalid Minimum Length: must be at least 1", viewModel.getErrorMessage());
    }

    @Test
    void testClearError() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.setMinimumLength(0);
        viewModel.validateSettings();
        
        assertFalse(viewModel.getErrorMessage().isEmpty());
        
        viewModel.clearError();
        
        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    void testPropertyBindings() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.minimumLengthProperty().set(15);
        assertEquals(15, viewModel.getMinimumLength());

        viewModel.mustIncludeDigitsProperty().set(true);
        assertTrue(viewModel.getMustIncludeDigits());

        viewModel.mustIncludeLowerCaseLettersProperty().set(true);
        assertTrue(viewModel.getMustIncludeLowerCaseLetters());

        viewModel.mustIncludeUpperCaseLettersProperty().set(true);
        assertTrue(viewModel.getMustIncludeUpperCaseLetters());
    }
    
    @Test
    void testSetGeneratedPassword() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.setGeneratedPassword("TestPassword123");
        assertEquals("TestPassword123", viewModel.getGeneratedPassword());
    }
    
    @Test
    void testSetErrorMessage() {
    	
    	PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
    	
        viewModel.setErrorMessage("Test error message");
        assertEquals("Test error message", viewModel.getErrorMessage());
    }
}