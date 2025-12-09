package edu.westga.cs1302.comic_collection.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CollectionTest {
    
    @Test
    public void testConstructorValidName() {
        Collection collection = new Collection("Marvel");
        assertEquals("Marvel", collection.getName());
        assertEquals(0, collection.getComics().size());
    }
    
    @Test
    public void testConstructorNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Collection(null);
        });
    }
    
    @Test
    public void testConstructorEmptyNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Collection("");
        });
    }
    
    @Test
    public void testAddComicValid() {
        Collection collection = new Collection("Test");
        Comic comic = new Comic("Spider-Man", 1);
        collection.addComic(comic);
        assertEquals(1, collection.getComics().size());
        assertEquals(comic, collection.getComics().get(0));
    }
    
    @Test
    public void testAddComicNullThrowsException() {
        Collection collection = new Collection("Test");
        assertThrows(IllegalArgumentException.class, () -> {
            collection.addComic(null);
        });
    }
    
    @Test
    public void testRemoveComic() {
        Collection collection = new Collection("Test");
        Comic comic = new Comic("Spider-Man", 1);
        collection.addComic(comic);
        collection.removeComic(comic);
        assertEquals(0, collection.getComics().size());
    }
    
    @Test
    public void testFindComicExists() {
        Collection collection = new Collection("Test");
        Comic comic = new Comic("Spider-Man", 1);
        collection.addComic(comic);
        Comic found = collection.findComic("Spider-Man", 1);
        assertEquals(comic, found);
    }
    
    @Test
    public void testFindComicNotExists() {
        Collection collection = new Collection("Test");
        Comic comic = new Comic("Spider-Man", 1);
        collection.addComic(comic);
        Comic found = collection.findComic("X-Men", 1);
        assertNull(found);
    }
}