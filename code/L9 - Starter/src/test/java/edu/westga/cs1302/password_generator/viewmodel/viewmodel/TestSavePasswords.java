package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;


public class TestSavePasswords {

    @TempDir
    Path dir;

   
    @Test
    public void testSaveEmptyPasswordHistory() throws IOException {
        ViewModel vm = new ViewModel();
        File testFile = this.dir.resolve("test_empty.txt").toFile();
        
        String result = vm.savePasswordsToFile(testFile.getAbsolutePath());
        
        assertTrue(result.isEmpty(), "Should return empty string on success");
        assertTrue(testFile.exists(), "File should be created");
        
        List<String> lines = Files.readAllLines(testFile.toPath());
        assertTrue(lines.isEmpty(), "File should be empty when no passwords");
    }

   
    @Test
    public void testSaveMultiplePasswords() throws IOException {
        ViewModel vm = new ViewModel();
        
        vm.getPasswordHistory().add("Password1");
        vm.getPasswordHistory().add("Password2");
        vm.getPasswordHistory().add("Password3");
        
        File testFile = this.dir.resolve("test_multiple.txt").toFile();
        String result = vm.savePasswordsToFile(testFile.getAbsolutePath());
        
        assertTrue(result.isEmpty(), "Should return empty string on success");
        assertTrue(testFile.exists(), "File should be created");
        
        List<String> lines = Files.readAllLines(testFile.toPath());
        assertEquals(3, lines.size(), "Should have 3 passwords");
        assertEquals("Password1", lines.get(0));
        assertEquals("Password2", lines.get(1));
        assertEquals("Password3", lines.get(2));
    }


    @Test
    public void testSaveWithInvalidPath() {
        ViewModel vm = new ViewModel();
        vm.getPasswordHistory().add("TestPassword");
        
        String invalidPath = "/invalid/path/that/does/not/exist/test.txt";
        String result = vm.savePasswordsToFile(invalidPath);
        
        assertFalse(result.isEmpty(), "Should return error message on failure");
        assertTrue(result.contains("Error saving file"), 
                   "Error message should indicate file save error");
    }

    @Test
    public void testSaveWithNullPath() {
        ViewModel vm = new ViewModel();
        vm.getPasswordHistory().add("TestPassword");
        
        String result = vm.savePasswordsToFile(null);
        
        assertFalse(result.isEmpty(), "Should return error message for null path");
        assertEquals("No file selected", result);
    }


    @Test
    public void testSaveWithEmptyPath() {
        ViewModel vm = new ViewModel();
        vm.getPasswordHistory().add("TestPassword");
        
        String result = vm.savePasswordsToFile("");
        
        assertFalse(result.isEmpty(), "Should return error message for empty path");
        assertEquals("No file selected", result);
    }
}