package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.Ascending;

public class TestCompare {

    @Test
    public void testCompareLowerPriorityFirst() {
        Task low = new Task("Low Task", "Low priority", TaskPriority.LOW);
        Task high = new Task("High Task", "High priority", TaskPriority.HIGH);

        Ascending comparator = new Ascending();
        assertTrue(comparator.compare(low, high) < 0);
    }

    @Test
    public void testCompareHigherPriorityFirst() {
        Task high = new Task("High Task", "High priority", TaskPriority.HIGH);
        Task low = new Task("Low Task", "Low priority", TaskPriority.LOW);

        Ascending comparator = new Ascending();
        assertTrue(comparator.compare(high, low) > 0);
    }

    @Test
    public void testCompareEqualPriority() {
        Task task1 = new Task("Task 1", "Medium priority", TaskPriority.MEDIUM);
        Task task2 = new Task("Task 2", "Medium priority", TaskPriority.MEDIUM);

        Ascending comparator = new Ascending();
        assertEquals(0, comparator.compare(task1, task2));
    }

    @Test
    public void testCompareWithNullTask1() {
        Task task2 = new Task("Task 2", "Medium priority", TaskPriority.MEDIUM);
        Ascending comparator = new Ascending();

        assertThrows(IllegalArgumentException.class, () -> {
            comparator.compare(null, task2);
        });
    }

    @Test
    public void testCompareWithNullTask2() {
        Task task1 = new Task("Task 1", "Medium priority", TaskPriority.MEDIUM);
        Ascending comparator = new Ascending();

        assertThrows(IllegalArgumentException.class, () -> {
            comparator.compare(task1, null);
        });
    }
}