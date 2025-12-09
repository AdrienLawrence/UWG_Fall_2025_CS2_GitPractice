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

import java.util.HashMap;
import java.util.Map;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindowViewModel {
    private StringProperty collectionName;
    private ListProperty<Collection> collections;
    private ObjectProperty<Collection> selectedCollection;
    
    private StringProperty comicTitle;
    private StringProperty comicIssue;
    private ListProperty<Comic> comicsInSelectedCollection;
    private ObjectProperty<Comic> selectedComic;
    
    private StringProperty searchTitle;
    private StringProperty searchIssue;
    
    private Map<String, Collection> comicToCollectionMap;
    
    /** Initializes the properties for the viewmodel.
     * 
     */
    public MainWindowViewModel() {
        this.collectionName = new SimpleStringProperty("");
        this.collections = new SimpleListProperty<Collection>(
            FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<Collection>();
        
        this.comicTitle = new SimpleStringProperty("");
        this.comicIssue = new SimpleStringProperty("");
        this.comicsInSelectedCollection = new SimpleListProperty<Comic>(
            FXCollections.observableArrayList());
        this.selectedComic = new SimpleObjectProperty<Comic>();
        
        this.searchTitle = new SimpleStringProperty("");
        this.searchIssue = new SimpleStringProperty("");
        
        this.comicToCollectionMap = new HashMap<>();
        
        this.setupSelectionListener();
    }
    
    /** Sets up listener for the collection listview.
     * 
     */
    private void setupSelectionListener() {
        this.selectedCollection.addListener((observable, oldValue, newValue) -> {
            this.comicsInSelectedCollection.clear();
            if (newValue != null) {
                this.comicsInSelectedCollection.addAll(newValue.getComics());
            }
        });
    }
    
    /** Returns the collection name property.
     * 
     * @return the collection name property
     */
    public StringProperty getCollectionName() {
        return this.collectionName;
    }
    
    /** Returns the collections list property.
     * 
     * @return the collections list property
     */
    public ListProperty<Collection> getCollections() {
        return this.collections;
    }
    
    /** Returns the selected collection.
     * 
     * @return the selected collection
     */
    public ObjectProperty<Collection> getSelectedCollection() {
        return this.selectedCollection;
    }
    
    /** Returns the comic title property.
     * 
     * @return the comic title property
     */
    public StringProperty getComicTitle() {
        return this.comicTitle;
    }
    
    /** Returns the comic issue property.
     * 
     * @return the comic issue property
     */
    public StringProperty getComicIssue() {
        return this.comicIssue;
    }
    
    /** Returns the comics in selected collection list property.
     * 
     * @return the comics in selected collection list property
     */
    public ListProperty<Comic> getComicsInSelectedCollection() {
        return this.comicsInSelectedCollection;
    }
    
    /** Returns the selected comic.
     * 
     * @return the selected comic
     */
    public ObjectProperty<Comic> getSelectedComic() {
        return this.selectedComic;
    }
    
    /** Returns the search title property.
     * 
     * @return the search title property
     */
    public StringProperty getSearchTitle() {
        return this.searchTitle;
    }
    
    /** Returns the search issue property.
     * 
     * @return the search issue property
     */
    public StringProperty getSearchIssue() {
        return this.searchIssue;
    }
    
    /** Adds a new collection with the current collection name.
     * 
     */
    public void addCollection() {
        String name = this.collectionName.get();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        
        Collection newCollection = new Collection(name);
        this.collections.add(newCollection);
    }
    
    /** Removes the selected collection.
     * 
     */
    public void removeCollection() {
        Collection selected = this.selectedCollection.get();
        if (selected != null) {
            for (Comic comic : selected.getComics()) {
                String key = this.createKey(comic.getTitle(), comic.getIssueNumber());
                this.comicToCollectionMap.remove(key);
            }
            this.collections.remove(selected);
        }
    }
    
    /** Adds a new comic to the selected collection.
     * 
     */
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
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("issue must be a number");
        }
        
        Collection selected = this.selectedCollection.get();
        if (selected == null) {
            throw new IllegalArgumentException("no collection selected");
        }
        
        Comic newComic = new Comic(title, issueNumber);
        selected.addComic(newComic);
        this.comicsInSelectedCollection.add(newComic);
        
        String key = this.createKey(title, issueNumber);
        this.comicToCollectionMap.put(key, selected);
    }
    
    /** Removes the selected comic from the selected collection.
     * 
     */
    public void removeComic() {
        Comic selected = this.selectedComic.get();
        Collection collection = this.selectedCollection.get();
        
        if (selected != null && collection != null) {
            collection.removeComic(selected);
            this.comicsInSelectedCollection.remove(selected);
            
            String key = this.createKey(selected.getTitle(), selected.getIssueNumber());
            this.comicToCollectionMap.remove(key);
        }
    }
    
    /** Searches for a comic by title and issue number.
     * 
     * @return search result message
     */
    public String searchComic() {
        String title = this.searchTitle.get();
        String issueText = this.searchIssue.get();
        
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be empty");
        }
        if (issueText == null || issueText.isEmpty()) {
            throw new IllegalArgumentException("issue cannot be empty");
        }
        
        int issueNumber;
        try {
            issueNumber = Integer.parseInt(issueText);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("issue must be a number");
        }
        
        String key = this.createKey(title, issueNumber);
        Collection collection = this.comicToCollectionMap.get(key);
        
        if (collection != null) {
            return "Comic '" + title + " #" + issueNumber + "' found in: " 
                + collection.getName();
        } else {
            return "Comic not found.";
        }
    }
    
    private String createKey(final String title, final int issueNumber) {
        return title + "|" + issueNumber;
    }
}