package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    
    @FXML private ListView comics;
    @FXML private Button addComicButton;
    @FXML private Button removeComicButton;

    private MainWindowViewModel vm;
    
    @FXML
    void initialize() {
        assert this.addCollectionButton != null : "fx:id=\"addCollectionButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.collections != null : "fx:id=\"collections\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.removeCollectionButton != null : "fx:id=\"removeCollectionButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.comics != null : "fx:id=\"comics\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.addComicButton != null : "fx:id=\"addComicButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.removeComicButton != null : "fx:id=\"removeComicButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        
        this.vm = new MainWindowViewModel();
        
        this.vm.getCollectionName().bind(this.name.textProperty());
        this.collections.setItems(this.vm.getCollections());
        this.vm.getSelectedCollection().bind(this.collections.getSelectionModel().selectedItemProperty());
        
        this.addCollectionButton.disableProperty().bind(this.name.textProperty().isEmpty());
        
        ContextMenu collectionContextMenu = new ContextMenu();
        MenuItem removeCollectionMenuItem = new MenuItem("Remove Collection");
        removeCollectionMenuItem.setOnAction(event -> this.vm.removeCollection());
        collectionContextMenu.getItems().add(removeCollectionMenuItem);
        this.collections.setContextMenu(collectionContextMenu);
        
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
        
        this.comics.setItems(this.vm.getComicsInSelectedCollection());
        this.vm.getSelectedComic().bind(this.comics.getSelectionModel().selectedItemProperty());
        
        ContextMenu comicContextMenu = new ContextMenu();
        MenuItem removeComicMenuItem = new MenuItem("Remove Comic");
        removeComicMenuItem.setOnAction(event -> this.vm.removeSelectedComic());
        comicContextMenu.getItems().add(removeComicMenuItem);
        this.comics.setContextMenu(comicContextMenu);
        
        this.addComicButton.setOnAction(event -> {
            this.openAddComicWindow();
        });
        
        this.removeComicButton.setOnAction(event -> {
            this.vm.removeComic();
        });
    }
    
    private void openAddComicWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddComicWindow.fxml"));
            Parent root = loader.load();
            
            AddComicWindow controller = loader.getController();
            controller.setViewModel(this.vm);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Comic");
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Cannot open add comic window");
            alert.showAndWait();
        }
    }
}