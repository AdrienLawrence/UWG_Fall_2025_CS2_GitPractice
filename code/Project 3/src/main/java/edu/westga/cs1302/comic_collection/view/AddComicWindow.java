package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/** Codebehind for the AddComicWindow.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AddComicWindow {
    @FXML private TextField titleField;
    @FXML private TextField issueField;
    @FXML private Button addButton;
    @FXML private Button cancelButton;
    
    private MainWindowViewModel vm;
    private Stage stage;
    
    @FXML
    void initialize() {
        assert this.titleField != null 
            : "fx:id=\"titleField\" was not injected.";
        assert this.issueField != null 
            : "fx:id=\"issueField\" was not injected.";
        assert this.addButton != null 
            : "fx:id=\"addButton\" was not injected.";
        assert this.cancelButton != null 
            : "fx:id=\"cancelButton\" was not injected.";
        
        this.addButton.setOnAction(event -> this.handleAdd());
        this.cancelButton.setOnAction(event -> this.closeWindow());
        
        this.addButton.disableProperty().bind(
            this.titleField.textProperty().isEmpty()
            .or(this.issueField.textProperty().isEmpty())
        );
    }
    
    /** Carries viewmodel from mainwindow.
     * 
     * @param vm the viewmodel instance
     */
    public void setViewModel(final MainWindowViewModel vm) {
        this.vm = vm;
        this.vm.getComicTitle().bind(this.titleField.textProperty());
        this.vm.getComicIssue().bind(this.issueField.textProperty());
    }
    
    /** Sets window.
     * 
     * @param stage the stage to open the window with
     */
    public void setStage(final Stage stage) {
        this.stage = stage;
    }
    
    /** Adds the comic using the viewmodel.
     * 
     */
    private void handleAdd() {
        try {
            this.vm.addComic();
            this.closeWindow();
        } catch (IllegalArgumentException error) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Error: " + error.getMessage());
            alert.showAndWait();
        }
    }
    
    /** Closes the window.
     * 
     */
    private void closeWindow() {
        this.vm.getComicTitle().unbind();
        this.vm.getComicIssue().unbind();
        this.vm.getComicTitle().set("");
        this.vm.getComicIssue().set("");
        
        Stage stage = (Stage) this.addButton.getScene().getWindow();
        stage.close();
    }
}