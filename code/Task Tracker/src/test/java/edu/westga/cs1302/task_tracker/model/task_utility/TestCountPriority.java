package edu.westga.cs1302.task_tracker.model.task_utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.TaskUtility;

class TestCountPriority {
	
	@Test
	void testNullForTasksList() {
		assertThrows(IllegalArgumentException.class, ()->{TaskUtility.countOfPriority(TaskPriority.HIGH, null);});
	}
	
	@Test
	void testEmptyTasksList() {
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, new ArrayList<Task>());
		
		assertEquals(0, result, "checking count");
	}
	
	@Test
	void testOneItemInTasksListMatchesPriority() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("name", "description", TaskPriority.HIGH));
		
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, tasks);
		
		assertEquals(1, result, "checking count");
	}
	
	@Test
	void testOneItemInTasksListDoesNotMatchPriority() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("name", "description", TaskPriority.MEDIUM));
		
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, tasks);
		
		assertEquals(0, result, "checking count");
	}
	
	@Test
	void testMultipleItemsInTasksListAllMatchPriority() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("name", "description", TaskPriority.HIGH));
		tasks.add(new Task("name", "description", TaskPriority.HIGH));
		
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, tasks);
		
		assertEquals(2, result, "checking count");
	}
	
	@Test
	void testMultipleItemsInTasksListSomeMatchPriority() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("name", "description", TaskPriority.HIGH));
		tasks.add(new Task("name", "description", TaskPriority.MEDIUM));
		
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, tasks);
		
		assertEquals(1, result, "checking count");
	}
	
	@Test
	void testMultipleItemsInTasksListNoneMatchPriority() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("name", "description", TaskPriority.MEDIUM));
		tasks.add(new Task("name", "description", TaskPriority.MEDIUM));
		
		int result = TaskUtility.countOfPriority(TaskPriority.HIGH, tasks);
		
		assertEquals(0, result, "checking count");
	}

}
