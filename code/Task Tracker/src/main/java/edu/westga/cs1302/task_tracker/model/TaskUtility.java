package edu.westga.cs1302.task_tracker.model;

import java.util.List;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/** Provides utility functions for working with tasks
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class TaskUtility {

	/** Returns the number of tasks with the specified priority in the provided list
	 * 
	 * @precondition tasks != null
	 * @postcondition none
	 * 
	 * @param priority the priority of tasks to include in the count
	 * @param tasks the list of tasks to use for the count
	 * 
	 * @return the count of the number of tasks in the provided list with the specified priority
	 */
	public static int countOfPriority(TaskPriority priority, List<Task> tasks) {
		if (tasks == null) {
			throw new IllegalArgumentException("tasks must not be null");
		}
		int count = 0;
		for (Task currTask : tasks) {
			if (currTask.getPriority() == priority) {
				count++;
			}
		}
		return count;
	}
	
	/** Convert String priority values to numbers for easier comparison in comparator 
	 * classes
	 * 
	 * @precondition task != null
	 * @postcondition none
	 * 
	 * @param priority the priority value of an input Task
	 * 
	 * @return an integer between 1 and 3 representing a task priority
	 * 
	 */
	public static int priorityToInt(Task.TaskPriority priority) {
		if (priority == null) {
			throw new IllegalArgumentException("task cannot be null");
		}
		
		switch (priority) {
			case LOW: return 1;
			case MEDIUM: return 2;
			case HIGH: return 3;
			default: throw new IllegalArgumentException("Invalid Task Priority");
		}
	}
}
