package edu.westga.cs1302.project1.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;
import edu.westga.cs1302.project1.model.PriorityCounter;
import java.util.List;

class TestPrioCounter {

	@Test
	void validTasksTest() {
		List<Task> tasks = Arrays.asList(
				new Task("n", "d", 1),
				new Task("n", "d", 2),
				new Task("n", "d", 3),
				new Task("n", "d", 1)
		);
		
		assertEquals(2, PriorityCounter.countTasks(1, tasks));
	}
	
	@Test
	void emptyTasksTest() {
		List<Task> tasks = Arrays.asList();
		
		assertEquals(0, PriorityCounter.countTasks(1, tasks));
	}
	
	
	@Test
	void nullTasksTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			PriorityCounter.countTasks(1, null);
		});
	}
	
	@Test
	void noTaskWithPrio() {
		List<Task> tasks = Arrays.asList(
				new Task("n", "d", 1),
				new Task("n", "d", 2),
				new Task("n", "d", 3),
				new Task("n", "d", 1)
		);
		
		assertEquals(0, PriorityCounter.countTasks(4, tasks));
	}
}
