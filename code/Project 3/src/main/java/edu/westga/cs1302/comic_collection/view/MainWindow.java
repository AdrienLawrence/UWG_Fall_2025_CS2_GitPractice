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

/** Codebehind for the MainWindow.
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
    
    @FXML private TextField comicName;
    @FXML private TextField comicIssue;
    @FXML private Button searchButton;

    private MainWindowViewModel vm;
    
    @FXML
    void initialize() {
        assert this.addCollectionButton != null 
            : "fx:id=\"addCollectionButton\" was not injected.";
        assert this.collections != null 
            : "fx:id=\"collections\" was not injected.";
        assert this.guiPane != null 
            : "fx:id=\"guiPane\" was not injected.";
        assert this.name != null 
            : "fx:id=\"name\" was not injected.";
        assert this.removeCollectionButton != null 
            : "fx:id=\"removeCollectionButton\" was not injected.";
        assert this.comics != null 
            : "fx:id=\"comics\" was not injected.";
        assert this.addComicButton != null 
            : "fx:id=\"addComicButton\" was not injected.";
        assert this.removeComicButton != null 
            : "fx:id=\"removeComicButton\" was not injected.";
        assert this.comicName != null 
            : "fx:id=\"comicName\" was not injected.";
        assert this.comicIssue != null 
            : "fx:id=\"comicIssue\" was not injected.";
        assert this.searchButton != null 
            : "fx:id=\"searchButton\" was not injected.";
        
        this.vm = new MainWindowViewModel();
        
        this.vm.getCollectionName().bind(this.name.textProperty());
        this.collections.setItems(this.vm.getCollections());
        this.vm.getSelectedCollection().bind(
            this.collections.getSelectionModel().selectedItemProperty());
        
        this.addCollectionButton.disableProperty().bind(
            this.name.textProperty().isEmpty());
        
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
        this.vm.getSelectedComic().bind(
            this.comics.getSelectionModel().selectedItemProperty());
        
        ContextMenu comicContextMenu = new ContextMenu();
        MenuItem removeComicMenuItem = new MenuItem("Remove Comic");
        removeComicMenuItem.setOnAction(event -> this.vm.removeComic());
        comicContextMenu.getItems().add(removeComicMenuItem);
        this.comics.setContextMenu(comicContextMenu);
        
        this.addComicButton.setOnAction(event -> {
            this.openAddComicWindow();
        });
        
        this.removeComicButton.setOnAction(event -> {
            this.vm.removeComic();
        });
        
        this.vm.getSearchTitle().bind(this.comicName.textProperty());
        this.vm.getSearchIssue().bind(this.comicIssue.textProperty());

        this.searchButton.setOnAction(event -> {
            this.handleSearch();
        });
        
        this.searchButton.disableProperty().bind(
            this.comicName.textProperty().isEmpty()
            .or(this.comicIssue.textProperty().isEmpty())
        );
    }
    
    /** Opens the add comic window when addcomic button is pressed.
     * 
     */
    private void openAddComicWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("AddComicWindow.fxml"));
            Parent root = loader.load();
            
            AddComicWindow controller = loader.getController();
            controller.setViewModel(this.vm);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Comic");
            stage.show();
        } catch (Exception exception) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Cannot open add comic window");
            alert.showAndWait();
        }
    }
    
    /** Searches for comic using binded viewmodel method.
     * 
     */
    private void handleSearch() {
        try {
            String result = this.vm.searchComic();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Result");
            alert.setHeaderText(null);
            alert.setContentText(result);
            alert.showAndWait();
        } catch (IllegalArgumentException error) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Search Error: " + error.getMessage());
            alert.showAndWait();
        }
    }
}