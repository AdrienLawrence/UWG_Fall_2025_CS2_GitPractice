package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private String name;
    private List<Comic> comics;
    
    public Collection(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
        this.comics = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Comic> getComics() {
        return new ArrayList<>(this.comics);
    }
    
    public void addComic(Comic comic) {
        if (comic == null) {
            throw new IllegalArgumentException("comic cannot be null");
        }
        this.comics.add(comic);
    }
    
    public void removeComic(Comic comic) {
        this.comics.remove(comic);
    }
    
    @Override
    public String toString() {
        return this.name + " (" + this.comics.size() + " comics)";
    }
}