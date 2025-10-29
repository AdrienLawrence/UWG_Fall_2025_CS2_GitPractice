package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompareName {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascendingName.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascendingName.compare(o1, null);});
	}
	
	@Test
	void testAppleBeforeBanana() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("banana", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testBananaAfterApple() {
		Task o1 = new Task("banana", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testSameNames() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testAppBeforeApple() {
		Task o1 = new Task("app", "desc", TaskPriority.HIGH);
		Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testAppleAfterApp() {
		Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
		Task o2 = new Task("app", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testCarBeforeCat() {
		Task o1 = new Task("car", "desc", TaskPriority.HIGH);
		Task o2 = new Task("cat", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testCatAfterCar() {
		Task o1 = new Task("cat", "desc", TaskPriority.HIGH);
		Task o2 = new Task("car", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testZBeforeZa() {
		Task o1 = new Task("Z", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Za", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testZaAfterZ() {
		Task o1 = new Task("Za", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Z", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
}