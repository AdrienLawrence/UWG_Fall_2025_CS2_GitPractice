package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingPriority;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestComparePrio {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingPriority ascending = new AscendingPriority();
		
		assertThrows(IllegalArgumentException.class, ()->{ascending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingPriority ascending = new AscendingPriority();
		
		assertThrows(IllegalArgumentException.class, ()->{ascending.compare(o1, null);});
	}
	
	@Test
	void testO1HighAndO2MEDIUM() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1HighAndO2LOW() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testO1MEDIUMAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1MEDIUMAndO2Medium() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1MediumAndO2Low() {
		Task o1 = new Task("name", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1LowAndO2Low() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.LOW);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1LowAndO2Medium() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.MEDIUM);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1LowAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.LOW);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1HighAndO2High() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingPriority ascending = new AscendingPriority();
		
		int result = ascending.compare(o1, o2);

		assertTrue(result == 0);
	}

}
