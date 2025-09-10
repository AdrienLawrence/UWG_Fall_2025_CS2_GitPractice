package edu.westga.cs1302.lab3.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */

public class MainWindow {
	
	private Bill bill;
	private BillView billView;
	
    @FXML
    private Button addItemButton;

    @FXML
    private TextField amountField;

    @FXML
    private Text amountText;

    @FXML
    private TextArea billDisplay;

    @FXML
    private TextField nameField;

    @FXML
    private Text nameText;
    
   
    /** Perform any needed initialization
     * 
     * @precondition None
     * 
     * @postcondition New empty Bill and BillView objects created
     */
    @FXML
	public void initialize() {
		this.bill = new Bill();
		this.billView = new BillView();
	}
	
    @FXML
    void addItem(ActionEvent event) {
    	String name = this.nameField.getText();
    	double amount = Double.parseDouble(this.amountField.getText());
    	
    	BillItem item = new BillItem(name, amount);
    	
    	this.bill.addItem(item);
    	
    	String billText = this.billView.getText(this.bill);
    	this.billDisplay.setText(billText);
    }

}
