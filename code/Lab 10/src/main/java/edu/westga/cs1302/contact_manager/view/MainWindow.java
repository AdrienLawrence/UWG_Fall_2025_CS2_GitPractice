package edu.westga.cs1302.contact_manager.view;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/** Codebehind for the MainWindow
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private Button addContact;
    @FXML private ListView contacts;
    @FXML private Button findContact;
    @FXML private AnchorPane guiPane;
    @FXML private TextField name;
    @FXML private TextField phoneNumber;
    @FXML private TextField searchCriteria;

    private MainWindowViewModel vm;
    
    @FXML
    void initialize() {
        assert this.addContact != null : "fx:id=\"addContact\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.contacts != null : "fx:id=\"contacts\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.findContact != null : "fx:id=\"findContact\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.searchCriteria != null : "fx:id=\"searchCriteria\" was not injected: check your FXML file 'MainWindow.fxml'.";
        
        this.vm = new MainWindowViewModel();
        
        this.vm.getName().bind(this.name.textProperty());
        this.vm.getPhoneNumber().bind(this.phoneNumber.textProperty());
        this.vm.getSearchCriteria().bind(this.searchCriteria.textProperty());
        this.contacts.setItems(this.vm.getContacts());
        
        this.addContact.setOnAction(
        								(event) -> {
        									try {
            									this.vm.addContact();
        									} catch (IllegalArgumentException error) {
												Alert alert = new Alert(AlertType.ERROR);
												alert.setContentText("Unable to Add Contact: " + error.getMessage());
												alert.showAndWait();
        									}
        								}
        							);
        
        this.findContact.setOnAction(
        								(event) -> {
        									try {
        										String info = this.vm.findContact();
												Alert alert = new Alert(AlertType.INFORMATION);
												alert.setTitle("Search Result");
												alert.setHeaderText(null);
												alert.setContentText(info);
												alert.showAndWait();
        									} catch (IllegalArgumentException error) {
												Alert alert = new Alert(AlertType.ERROR);
												alert.setHeaderText("Error Trying to Find Contact");
												alert.setContentText(error.getMessage());
												alert.showAndWait();
        									}
        								}
        							);
        
    }
}

