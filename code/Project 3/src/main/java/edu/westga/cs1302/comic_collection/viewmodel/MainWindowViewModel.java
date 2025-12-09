package edu.westga.cs1302.comic_collection.viewmodel;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class MainWindowViewModel {
    private StringProperty collectionName;
    private ListProperty<Collection> collections;
    private ObjectProperty<Collection> selectedCollection;
    
    private StringProperty comicTitle;
    private StringProperty comicIssue;
    private ListProperty<Comic> comicsInSelectedCollection;
    private ObjectProperty<Comic> selectedComic;
    
    public MainWindowViewModel() {
        this.collectionName = new SimpleStringProperty("");
        this.collections = new SimpleListProperty<Collection>(FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<Collection>();
        
        this.comicTitle = new SimpleStringProperty("");
        this.comicIssue = new SimpleStringProperty("");
        this.comicsInSelectedCollection = new SimpleListProperty<Comic>(FXCollections.observableArrayList());
        this.selectedComic = new SimpleObjectProperty<Comic>();
        
        this.setupSelectionListener();
    }
    
    private void setupSelectionListener() {
        this.selectedCollection.addListener((observable, oldValue, newValue) -> {
            this.comicsInSelectedCollection.clear();
            if (newValue != null) {
                this.comicsInSelectedCollection.addAll(newValue.getComics());
            }
        });
    }
    
    public StringProperty getCollectionName() {
        return this.collectionName;
    }
    
    public ListProperty<Collection> getCollections() {
        return this.collections;
    }
    
    public ObjectProperty<Collection> getSelectedCollection() {
        return this.selectedCollection;
    }
    
    public StringProperty getComicTitle() {
        return this.comicTitle;
    }
    
    public StringProperty getComicIssue() {
        return this.comicIssue;
    }
    
    public ListProperty<Comic> getComicsInSelectedCollection() {
        return this.comicsInSelectedCollection;
    }
    
    public ObjectProperty<Comic> getSelectedComic() {
        return this.selectedComic;
    }
    
    public void addCollection() {
        String name = this.collectionName.get();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        
        Collection newCollection = new Collection(name);
        this.collections.add(newCollection);
        this.collectionName.set("");
    }
    
    public void removeCollection() {
        Collection selected = this.selectedCollection.get();
        if (selected != null) {
            this.collections.remove(selected);
            this.selectedCollection.set(null);
        }
    }
    
    public void addComic() {
        String title = this.comicTitle.get();
        String issueText = this.comicIssue.get();
        
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be empty");
        }
        if (issueText == null || issueText.isEmpty()) {
            throw new IllegalArgumentException("issue cannot be empty");
        }
        
        int issueNumber;
        try {
            issueNumber = Integer.parseInt(issueText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("issue must be a number");
        }
        
        Collection selected = this.selectedCollection.get();
        if (selected == null) {
            throw new IllegalArgumentException("no collection selected");
        }
        
        Comic newComic = new Comic(title, issueNumber);
        selected.addComic(newComic);
        this.comicsInSelectedCollection.add(newComic);
        
        this.comicTitle.set("");
        this.comicIssue.set("");
    }
    
    public void removeComic() {
        Comic selected = this.selectedComic.get();
        Collection collection = this.selectedCollection.get();
        
        if (selected != null && collection != null) {
            collection.removeComic(selected);
            this.comicsInSelectedCollection.remove(selected);
            this.selectedComic.set(null);
        }
    }
}