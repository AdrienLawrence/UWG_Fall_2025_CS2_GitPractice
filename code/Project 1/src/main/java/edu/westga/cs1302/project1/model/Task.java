package edu.westga.cs1302.project1.model;

/** Class for containing task objects and attributes
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Task {
	
	private final String name;
	
	private String description;
	
	private final int priority;

	/** Constructor method
	 * 
	 * @precondition name != null or only whitespace, desc != null or only whitespace, prio is a positive number
	 * 
	 * @postcondition None
	 * 
	 * @param name task name input
	 * @param desc task description input
	 * @param prio task priority input
	 */
	public Task(String name, String desc, int prio) {
		
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
		
		if (desc == null || desc.trim().isEmpty()) {
			throw new IllegalArgumentException("Description cannot be null or blank");
		}
		
		if (prio < 1) {
			throw new IllegalArgumentException("Priority must be a chosen number greater than 0");
		}
		
		this.name = name;
		this.description = desc;
		this.priority = prio;
	}
	
	/** Returns name attribute
	 * 
	 * @precondition None
	 * 
	 * @postcondition None
	 * 
	 * @return name attribute
	 */
	public String getName() {
		return this.name;
	}
	
	/** Returns description attriibute
	 * 
	 * @precondition None
	 * 
	 * @postcondition None
	 * 
	 * @return description attribute
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** Returns priority attribute
	 * 
	 * @precondition None
	 * 
	 * @postcondition None
	 * 
	 * @return priority attribute
	 */
	public int getPriority() {
		return this.priority;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	/** sets description to a new input description
	 * 
	 * @precondition desc != null or only whitespace
	 * 
	 * @postcondition None
	 * 
	 * @param desc the new description
	 */
	public void setDesc(String desc) {
		if (desc == null || desc.trim().isEmpty()) {
			throw new IllegalArgumentException("Description cannot be null or blank");
		}
		this.description = desc;
	}
	
}
