package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/** ContainerTask class for creating tasks that have related subtasks 
 * 
 * @author CS 1302
 * 
 * @version Fall 2025
 */
public class ContainerTask extends Task {
	
	private List<Task> subtasks;
	
	/** Constructor for ContainerTask objects
	 * 
	 * @param name name of original task
	 * @param description description of original task
	 * @param priority priority of original task
	 * @param firstSubtask first subtask to be assigned to original task
	 */
	public ContainerTask(String name, String description, TaskPriority priority, Task firstSubtask) {
		super(name, description, priority);
		
		if (firstSubtask == null) {
			throw new IllegalArgumentException("subtask must not be null");
		}
		
		this.subtasks = new ArrayList<Task>();
		this.subtasks.add(firstSubtask);
	}
	
	@Override
	public ContainerTask addTask(Task subtask) {
		if (subtask == null) {
			throw new IllegalArgumentException("subtask must not be null");
		}
		this.subtasks.add(subtask);
		return this;
	}

	@Override
	public List<Task> getSubTasks() {
		return this.subtasks;
	}
	
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}
