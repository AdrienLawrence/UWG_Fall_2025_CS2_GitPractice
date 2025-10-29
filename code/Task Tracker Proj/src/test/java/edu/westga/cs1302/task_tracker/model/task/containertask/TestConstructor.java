package edu.westga.cs1302.task_tracker.model.task.containertask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestConstructor {

	@Test
	void testConstructorWithNullFirstSubtask() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContainerTask("Name", "Description", TaskPriority.HIGH, null);
		});
	}

	@Test
	void testConstructorInheritsProperties() {
		Task firstSubtask = new Task("Vacuum", "Vacuum floor", TaskPriority.LOW);
		ContainerTask containerTask = new ContainerTask("Clean Room", "Clean everything", TaskPriority.MEDIUM, firstSubtask);
		
		assertEquals("Clean Room", containerTask.getName());
		assertEquals("Clean everything", containerTask.getDescription());
		assertEquals(TaskPriority.MEDIUM, containerTask.getPriority());
	}

	@Test
	void testConstructorAddsFirstSubtask() {
		Task firstSubtask = new Task("First", "First desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, firstSubtask);
		
		List<Task> subtasks = containerTask.getSubTasks();
		assertEquals(1, subtasks.size());
		assertEquals("First", subtasks.get(0).getName());
	}

	@Test
	void testAddTaskNullSubtask() {
		Task firstSubtask = new Task("First", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, firstSubtask);
		
		assertThrows(IllegalArgumentException.class, () -> {
			containerTask.addTask(null);
		});
	}

	@Test
	void testAddTaskReturnsThis() {
		Task firstSubtask = new Task("First", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, firstSubtask);
		
		Task newSubtask = new Task("Second", "Desc", TaskPriority.LOW);
		ContainerTask returnedTask = containerTask.addTask(newSubtask);
		
		assertSame(containerTask, returnedTask);
	}

	@Test
	void testAddTaskAccumulatesSubtasks() {
		Task firstSubtask = new Task("First", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, firstSubtask);
		
		Task secondSubtask = new Task("Second", "Desc", TaskPriority.LOW);
		containerTask.addTask(secondSubtask);
		
		Task thirdSubtask = new Task("Third", "Desc", TaskPriority.HIGH);
		containerTask.addTask(thirdSubtask);
		
		List<Task> subtasks = containerTask.getSubTasks();
		assertEquals(3, subtasks.size());
		assertEquals("First", subtasks.get(0).getName());
		assertEquals("Second", subtasks.get(1).getName());
		assertEquals("Third", subtasks.get(2).getName());
	}

	@Test
	void testGetSubTasksReturnsActualList() {
		Task subtask = new Task("Subtask", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, subtask);
		
		List<Task> subtasks = containerTask.getSubTasks();
		assertFalse(subtasks.isEmpty());
		assertEquals(1, subtasks.size());
	}

	@Test
	void testToStringIncludesIndicator() {
		Task subtask = new Task("Vacuum", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Clean Room", "Desc", TaskPriority.HIGH, subtask);
		
		String result = containerTask.toString();
		assertTrue(result.contains("(+)"));
		assertTrue(result.contains("Clean Room"));
	}

	@Test
	void testInstanceOfTask() {
		Task subtask = new Task("Subtask", "Desc", TaskPriority.MEDIUM);
		ContainerTask containerTask = new ContainerTask("Original", "Desc", TaskPriority.HIGH, subtask);
		
		assertTrue(containerTask instanceof Task);
	}
}