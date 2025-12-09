package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/** Codebehind for the MainWindow
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private Button addCollectionButton;
    @FXML private ListView collections;
    @FXML private AnchorPane guiPane;
    @FXML private TextField name;
    @FXML private Button removeCollectionButton;

    private MainWindowViewModel vm;
    
    @FXML
    void initialize() {
        assert this.addCollectionButton != null : "fx:id=\"addCollection\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.collections != null : "fx:id=\"collections\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.removeCollectionButton != null : "fx:id=\"removeCollectionButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        
        this.vm = new MainWindowViewModel();
        
        this.vm.getCollectionName().bind(this.name.textProperty());
        this.collections.setItems(this.vm.getCollections());
        this.vm.getSelectedCollection().bind(this.collections.getSelectionModel().selectedItemProperty());
        
        ContextMenu contextMenu = new ContextMenu();
        MenuItem removeMenuItem = new MenuItem("Remove Collection");
        removeMenuItem.setOnAction(event -> this.vm.removeCollection());
        contextMenu.getItems().add(removeMenuItem);
        this.collections.setContextMenu(contextMenu);
        
        this.addCollectionButton.setOnAction(event -> {
            try {
                this.vm.addCollection();
            } catch (IllegalArgumentException error) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Error: " + error.getMessage());
                alert.showAndWait();
            }
        });
        
        this.removeCollectionButton.setOnAction(event -> {
            this.vm.removeCollection();
        });
        
        this.addCollectionButton.disableProperty().bind(
        	    this.name.textProperty().isEmpty()
        	);
    }
}