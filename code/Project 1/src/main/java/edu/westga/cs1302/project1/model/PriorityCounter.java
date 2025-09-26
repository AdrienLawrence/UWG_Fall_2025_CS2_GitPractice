package edu.westga.cs1302.project1.model;

import java.util.List;



public class PriorityCounter {

	public static int countTasks(int p, List<Task> tasks) {
		
		if (tasks == null) {
			throw new IllegalArgumentException("Tasks list cannot be null");
		}
		
		int count = 0;
		
		for (Task task: tasks) {
			if (task.getPriority() == p) {
				count++;
			}
		}
		
		return count;
		
	}
}
