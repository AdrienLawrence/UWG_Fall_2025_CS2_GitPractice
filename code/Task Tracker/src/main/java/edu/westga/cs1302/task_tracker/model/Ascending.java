package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/**
 * Compares tasks by priority in ascending order, low to high
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Ascending implements Comparator<Task> {
	
	/** compares two tasks, returns positive if task 1 is a higher priority and 
	 * thus should come second, negative if the reverse is true, and zero if they are the same
	 * priority
	 * 
	 * @precondition task 1 != null, task 2 != null
	 * @postcondition None
	 * 
	 * @param task1 Task to be compared
	 * @param task2 Task to be compared to
	 * 
	 * @return an integer, positive if task 1 is of greater priority, negative if of lesser priority, and zero if of equal priority
	 */
	@Override
	public int compare(Task task1, Task task2) {
		if (task1 == null || task2 == null) {
			throw new IllegalArgumentException("Tasks cannot be null");
		}
		
		return TaskUtility.priorityToInt(task1.getPriority()) - TaskUtility.priorityToInt(task2.getPriority());
	}
	
	/**
	 * Returns a string representation of the class for the combobox
	 * 
	 * @precondition None
	 * @postcondition None
	 * 
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Ascending";
	}
	
}
