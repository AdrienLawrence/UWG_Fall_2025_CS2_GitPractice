package edu.westga.cs1302.project1.model;

public class Task {
	
	private final String name;
	
	private String description;
	
	private final int priority;

	public Task(String n, String d, int p) {
		
		if (n == null || n.isEmpty() || n.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
		
		if (d == null || d.trim().isEmpty()) {
			throw new IllegalArgumentException("Description cannot be null or blank");
		}
		
		if (p < 1) {
			throw new IllegalArgumentException("Priority must be a chosen number greater than 0");
		}
		
		this.name = n;
		this.description = d;
		this.priority = p;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public void setDesc(String d) {
		if (d == null || d.trim().isEmpty()) {
			throw new IllegalArgumentException("Description cannot be null or blank");
		}
		this.description = d;
	}
	
}
