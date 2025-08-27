package edu.westga.cs1302.lab1.view;

//Importing the Bill to view

import edu.westga.cs1302.lab1.model.Bill;

/**This class is responsible for displaying 
 * the Bill object, as previously handled by the 
 * Bill class
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	private static final double TAX_RATE = 0.1;
	private static final double TIP_RATE = 0.2;
	private Bill billDisplay;
	
	/**Defines the new billDisplay object 
	 * to be used in the BillView class
	 * 
	 * @precondition billDisplay != null
	 * @postcondition bill argument is assigned to BillDisplay
	 * 
	 * @param bill the bill to be assigned
	 */
	public BillView(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("Bill cannot be null");
		}
		this.billDisplay = bill;
	}
	
	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText() {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (var item : this.billDisplay.getItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		double tax = subTotal * TAX_RATE;
		double tip = subTotal * TIP_RATE;
		text += "TAX - $" + tax + System.lineSeparator();
		text += "TIP - $" + tip + System.lineSeparator();
		text += "TOTAL - $" + (subTotal + tip + tax);
		
		return text;
	}
	
}
