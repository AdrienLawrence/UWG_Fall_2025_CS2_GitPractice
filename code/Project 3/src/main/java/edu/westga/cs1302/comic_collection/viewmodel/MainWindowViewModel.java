package edu.westga.cs1302.comic_collection.viewmodel;

import edu.westga.cs1302.comic_collection.model.Collection;
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
    
    public MainWindowViewModel() {
        this.collectionName = new SimpleStringProperty("");
        this.collections = new SimpleListProperty<Collection>(FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<Collection>();
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
}