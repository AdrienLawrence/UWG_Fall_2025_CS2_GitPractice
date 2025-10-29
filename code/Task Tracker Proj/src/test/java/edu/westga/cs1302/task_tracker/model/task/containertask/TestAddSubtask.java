package edu.westga.cs1302.task_tracker.model.task.containertask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddSubtask {

	@Test
	void testAddSubtaskNull() {
		Task firstSubtask = new Task("First", "Description", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Main Task", "Description", TaskPriority.HIGH, firstSubtask);
		
		assertThrows(IllegalArgumentException.class, () -> {
			containerTask.addTask(null);
		});
	}

	@Test
	void testAddSubtaskReturnsThis() {
		Task firstSubtask = new Task("First", "Description", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Main Task", "Description", TaskPriority.HIGH, firstSubtask);
		
		Task newSubtask = new Task("Second", "Description", TaskPriority.LOW);
		ContainerTask result = containerTask.addTask(newSubtask);
		
		assertSame(containerTask, result);
	}

	@Test
	void testAddSubtaskAccumulates() {
		Task firstSubtask = new Task("First", "Description", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Main Task", "Description", TaskPriority.HIGH, firstSubtask);
		
		Task secondSubtask = new Task("Second", "Description", TaskPriority.LOW);
		containerTask.addTask(secondSubtask);
		
		Task thirdSubtask = new Task("Third", "Description", TaskPriority.HIGH);
		containerTask.addTask(thirdSubtask);
		
		assertEquals(3, containerTask.getSubTasks().size());
		assertEquals("First", containerTask.getSubTasks().get(0).getName());
		assertEquals("Second", containerTask.getSubTasks().get(1).getName());
		assertEquals("Third", containerTask.getSubTasks().get(2).getName());
	}

	@Test
	void testAddSubtaskMaintainsOriginalProperties() {
		Task firstSubtask = new Task("First", "Description", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Main Task", "Main Description", TaskPriority.HIGH, firstSubtask);
		
		Task newSubtask = new Task("New Subtask", "New Desc", TaskPriority.LOW);
		containerTask.addTask(newSubtask);
		
		// Verify main task properties unchanged
		assertEquals("Main Task", containerTask.getName());
		assertEquals("Main Description", containerTask.getDescription());
		assertEquals(TaskPriority.HIGH, containerTask.getPriority());
	}
}