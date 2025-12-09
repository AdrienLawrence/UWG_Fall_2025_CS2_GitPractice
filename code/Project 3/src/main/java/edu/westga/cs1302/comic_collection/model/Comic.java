package edu.westga.cs1302.comic_collection.model;

/** Class for storing comic objects.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Comic {
    private String title;
    private int issueNumber;
    
    /** Constructor for comic object.
     * 
     * @precondition title != null and issueNumber <= 0
     * @postcondition none
     * 
     * @param title the title given for the comic
     * @param issueNumber the issue given for the comic
     */
    public Comic(final String title, final int issueNumber) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("invalid title");
        }
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("invalid issue number");
        }
        this.title = title;
        this.issueNumber = issueNumber;
    }
    
    /** Returns the title of the comic.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the title of the comic
     */
    public String getTitle() {
        return this.title;
    }
    
    /** Returns the issue of the comic.
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the issue of the comic
     */
    public int getIssueNumber() {
        return this.issueNumber;
    }
    
    @Override
    public String toString() {
        return this.title + " #" + this.issueNumber;
    }
}