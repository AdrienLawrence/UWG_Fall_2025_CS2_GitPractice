package edu.westga.cs1302.comic_collection.viewmodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class MainWindowViewModelTest {
    
    private MainWindowViewModel vm;
    
    @BeforeEach
    public void setUp() {
        this.vm = new MainWindowViewModel();
    }
    
    @Test
    public void testAddCollectionValid() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        assertEquals(1, this.vm.getCollections().size());
        assertEquals("Marvel", this.vm.getCollections().get(0).getName());
    }
    
    @Test
    public void testAddCollectionEmptyNameThrowsException() {
        this.vm.getCollectionName().set("");
        assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addCollection();
        });
    }
    
    @Test
    public void testAddComicValid() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        this.vm.getCollections().get(0);
        
        this.vm.getSelectedCollection().set(this.vm.getCollections().get(0));
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("1");
        
        this.vm.addComic();
        assertEquals(1, this.vm.getComicsInSelectedCollection().size());
        assertEquals("Spider-Man #1", this.vm.getComicsInSelectedCollection().get(0).toString());
    }
    
    @Test
    public void testAddComicNoCollectionSelectedThrowsException() {
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("1");
        
        assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addComic();
        });
    }
    
    @Test
    public void testAddComicInvalidIssueThrowsException() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        this.vm.getSelectedCollection().set(this.vm.getCollections().get(0));
        
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("abc");
        
        assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addComic();
        });
    }
    
    @Test
    public void testFindComicExists() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        this.vm.getSelectedCollection().set(this.vm.getCollections().get(0));
        
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("1");
        this.vm.addComic();
        
        this.vm.getSearchTitle().set("Spider-Man");
        this.vm.getSearchIssue().set("1");
        
        String result = this.vm.searchComic();
        assertTrue(result.contains("found in: Marvel"));
    }
    
    @Test
    public void testFindComicNotExists() {
        this.vm.getSearchTitle().set("Spider-Man");
        this.vm.getSearchIssue().set("1");
        
        String result = this.vm.searchComic();
        assertEquals("Comic not found.", result);
    }
    
    @Test
    public void testRemoveCollection() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        
        this.vm.getSelectedCollection().set(this.vm.getCollections().get(0));
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("1");
        this.vm.addComic();
        
        this.vm.removeCollection();
        assertEquals(0, this.vm.getCollections().size());
        
        this.vm.getSearchTitle().set("Spider-Man");
        this.vm.getSearchIssue().set("1");
        String result = this.vm.searchComic();
        assertEquals("Comic not found.", result);
    }
    
    @Test
    public void testRemoveSelectedComic() {
        this.vm.getCollectionName().set("Marvel");
        this.vm.addCollection();
        this.vm.getSelectedCollection().set(this.vm.getCollections().get(0));
        
        this.vm.getComicTitle().set("Spider-Man");
        this.vm.getComicIssue().set("1");
        this.vm.addComic();
        
        this.vm.getSelectedComic().set(this.vm.getComicsInSelectedCollection().get(0));
        this.vm.removeComic();
        
        assertEquals(0, this.vm.getComicsInSelectedCollection().size());
        
        this.vm.getSearchTitle().set("Spider-Man");
        this.vm.getSearchIssue().set("1");
        String result = this.vm.searchComic();
        assertEquals("Comic not found.", result);
    }
}