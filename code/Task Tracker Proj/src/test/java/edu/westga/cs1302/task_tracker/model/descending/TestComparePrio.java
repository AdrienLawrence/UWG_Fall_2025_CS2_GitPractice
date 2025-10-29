package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingPriority;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestComparePrio {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingPriority descending = new DescendingPriority();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingPriority descending = new DescendingPriority();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
	}
	
	@Test
	void testO1HighAndO2MEDIUM() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1HighAndO2LOW() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testO1MEDIUMAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1MEDIUMAndO2Medium() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1MediumAndO2Low() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1LowAndO2Low() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1LowAndO2Medium() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1LowAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1HighAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingPriority descending = new DescendingPriority();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}

}
