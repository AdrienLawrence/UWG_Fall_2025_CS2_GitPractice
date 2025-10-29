package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestSetDescription {

	@Test
	void testNullDescription() {
		Task task = new Task("name", "description", TaskPriority.HIGH);
		
		assertThrows(IllegalArgumentException.class, ()->{task.setDescription(null);});
	}

	@Test
	void testValidDescription() {
		Task task = new Task("name", "description", TaskPriority.HIGH);
		
		task.setDescription("new description");
		
		assertEquals("new description", task.getDescription(), "checking description");
	}

}
