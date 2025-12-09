package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;
import java.util.List;

/** Class for storing collections of comic objects.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Collection {
    private String name;
    private List<Comic> comics;
    
    /** Constructor for Collection class.
     * 
     * @precondition name != null
     * @postcondition none
     * 
     * @param name name of collection
     */
    public Collection(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
        this.comics = new ArrayList<>();
    }
    
    /** Gets the name of the collection.
     * 
     * @return the name of the collection
     */
    public String getName() {
        return this.name;
    }
    
    /** Returns the list of comics in collection.
     *
     * @return the list of comic objects in collection
     */
    public List<Comic> getComics() {
        return new ArrayList<>(this.comics);
    }
    
    /** Adds a comic object to the collection.
     * 
     * @precondition comic != null
     * @postcondition none
     * 
     * @param comic the comic to add to the collection
     */
    public void addComic(final Comic comic) {
        if (comic == null) {
            throw new IllegalArgumentException("comic cannot be null");
        }
        this.comics.add(comic);
    }
    
    /** Removes a comic object from the collection.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param comic the comic to be removed
     */
    public void removeComic(final Comic comic) {
        this.comics.remove(comic);
    }
    
    @Override
    public String toString() {
        return this.name + " (" + this.comics.size() + " comics)";
    }
    
    /** Searches for a comic object in the collection with the given name and issue.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param title name of desired comic
     * @param issueNumber issue of desired comic
     * 
     * @return the comic object if found, null if no comic is found
     */
    public Comic findComic(final String title, final int issueNumber) {
        for (Comic comic : this.comics) {
            if (comic.getTitle().equals(title) 
                    && comic.getIssueNumber() == issueNumber) {
                return comic;
            }
        }
        return null;
    }
}