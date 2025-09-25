package edu.westga.cs1302.project1.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;

class TestConstructor {

    @Test
    void validParamTest() {
        Task task = new Task("Study", "Study for exam", 1);
        
        assertEquals("Study", task.getName());
        assertEquals("Study for exam", task.getDescription());
        assertEquals(1, task.getPriority());
    }
    
    @Test
    void nameReturnTest() {
        Task task = new Task("Homework", "Math assignment", 2);
        assertEquals("Homework", task.toString());
    }
    
    @Test
    void nullNameTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Valid description", 1);
        });
    }
    
    @Test
    void blankNameTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("   ", "desc", 1);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "desc", 1);
        });
    }
    
    @Test
    void nullDescTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("name", null, 1);
        });
    }
    
    @Test
    void blankDescTest() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Task("name", "", 1);
    	});
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Task("name", "  ", 1);
    	});
    }
    
    @Test
    void zeroAsPrioTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("name", "desc", 0);
        });
    }
    
    @Test
    void negativePrioTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("name", "desc", -5);
        });
    }
    
    
    @Test
    void validDescUpdateTest() {
    	Task task = new Task("name", "desc1", 1);
    	task.setDesc("desc2");
    	assertEquals("desc2", task.getDescription());
    }
    
    @Test
    void nullDescUpdateTest() {
    	Task task = new Task("name", "desc1", 1);
    	assertThrows(IllegalArgumentException.class, () -> {
    		task.setDesc(null);
    	});
    }
    
    @Test
    void blankDescUpdateTest() {
    	Task task = new Task("name", "desc1", 1);
    	assertThrows(IllegalArgumentException.class, () -> {
    		task.setDesc("");
    	});
    	
    	assertThrows(IllegalArgumentException.class, () -> {
    		task.setDesc("  ");
    	});
    }
	
}
