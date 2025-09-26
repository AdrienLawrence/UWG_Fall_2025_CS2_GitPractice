package edu.westga.cs1302.project1.model;

import java.util.List;

/**
 * Utility class for counting 
 * # of tasks for a given priority
 * 
 * @author CS 1302
 * @version Fall 2025
 *
 */
public class PriorityCounter {

	/** The logic for calculating the tasks per priority
	 * 
	 * @precondition tasks != null
	 * 
	 * @postcondition None
	 * 
	 * @param prio A given priority
	 * @param tasks the task list to be used
	 * @return the count of tasks per priority
	 */
	public static int countTasks(int prio, List<Task> tasks) {
		
		if (tasks == null) {
			throw new IllegalArgumentException("Tasks list cannot be null");
		}
		
		int count = 0;
		
		for (Task task: tasks) {
			if (task.getPriority() == prio) {
				count++;
			}
		}
		
		return count;
		
	}
}
