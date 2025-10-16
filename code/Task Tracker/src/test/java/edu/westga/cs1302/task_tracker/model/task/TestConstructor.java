package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Task(null, "description", TaskPriority.HIGH);});
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("", "description", TaskPriority.HIGH);});
	}

	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("name", null, TaskPriority.HIGH);});
	}

	@Test
	void testNullPriority() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("name", "description", null);});
	}

	@Test
	void testValidArguments() {
		Task result = new Task("name", "description", TaskPriority.HIGH);
		
		assertEquals("name", result.getName(), "checking name");
		assertEquals("description", result.getDescription(), "checking description");
		assertEquals(TaskPriority.HIGH, result.getPriority(), "checking priority");
	}

}
