package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestMinLenInput {

    @Test
    void testValidSingleDigit() {
        ViewModel vm = new ViewModel();
        assertTrue(vm.isMinLenValid("5"));
    }
    
    @Test
    void testValidMultipleDigits() {
        ViewModel vm = new ViewModel();
        assertTrue(vm.isMinLenValid("25"));
    }
    
    @Test
    void testInvalidLetter() {
    	ViewModel vm = new ViewModel();
    	assertFalse(vm.isMinLenValid("abc"));
    }
}