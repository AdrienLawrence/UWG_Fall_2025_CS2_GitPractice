package edu.westga.cs1302.comic_collection.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComicTest {
    
    @Test
    public void testConstructorValid() {
        Comic comic = new Comic("Spider-Man", 1);
        assertEquals("Spider-Man", comic.getTitle());
        assertEquals(1, comic.getIssueNumber());
    }
    
    @Test
    public void testConstructorNullTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic(null, 1);
        });
    }
    
    @Test
    public void testConstructorEmptyTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic("", 1);
        });
    }
    
    @Test
    public void testConstructorZeroIssueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic("Spider-Man", 0);
        });
    }
    
    @Test
    public void testConstructorNegativeIssueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic("Spider-Man", -1);
        });
    }
    
    @Test
    public void testToString() {
        Comic comic = new Comic("Spider-Man", 1);
        assertEquals("Spider-Man #1", comic.toString());
    }
}