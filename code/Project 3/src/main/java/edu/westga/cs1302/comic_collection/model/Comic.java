package edu.westga.cs1302.comic_collection.model;

public class Comic {
    private String title;
    private int issueNumber;
    
    public Comic(String title, int issueNumber) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("invalid title");
        }
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("invalid issue number");
        }
        this.title = title;
        this.issueNumber = issueNumber;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getIssueNumber() {
        return this.issueNumber;
    }
    
    @Override
    public String toString() {
        return this.title + " #" + this.issueNumber;
    }
}