package edu.westga.cs1302.comic_collection.model;

public class Collection {
    private String name;
    
    public Collection(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}