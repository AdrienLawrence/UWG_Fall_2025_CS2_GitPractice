package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompareName {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descendingName.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descendingName.compare(o1, null);});
	}
	
	@Test
	void testAppleAfterBanana() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("banana", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testBananaBeforeApple() {
		Task o1 = new Task("banana", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testSameNames() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testAppAfterApple() {
		Task o1 = new Task("app", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testAppleBeforeApp() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("app", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testCarAfterCat() {
		Task o1 = new Task("car", "desc", TaskPriority.HIGH);
		Task o2 = new Task("cat", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testCatBeforeCar() {
		Task o1 = new Task("cat", "desc", TaskPriority.HIGH);
		Task o2 = new Task("car", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testZAfterZa() {
		Task o1 = new Task("Z", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Za", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testZaBeforeZ() {
		Task o1 = new Task("Za", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Z", "desc", TaskPriority.HIGH);
		DescendingName descendingName = new DescendingName();
		
		int result = descendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
}