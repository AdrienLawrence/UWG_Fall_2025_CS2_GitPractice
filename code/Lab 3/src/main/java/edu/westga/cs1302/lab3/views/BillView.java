package edu.westga.cs1302.lab3.views;

import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill constructor input
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : bill.getItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + this.roundToNearestHundredth(subTotal) + System.lineSeparator();
		double tax = subTotal * Bill.TAX_RATE;
		double tip = subTotal * Bill.TIP_RATE;
		text += "TAX - $" + this.roundToNearestHundredth(tax) + System.lineSeparator();
		text += "TIP - $" + this.roundToNearestHundredth(tip) + System.lineSeparator();
		text += "TOTAL - $" + this.roundToNearestHundredth(subTotal + tip + tax);
		
		return text;
	}
	
	private double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
