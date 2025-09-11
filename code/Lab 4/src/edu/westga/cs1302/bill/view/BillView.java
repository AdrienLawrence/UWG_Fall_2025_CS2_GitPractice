package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;
import java.util.ArrayList;

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
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		
		ArrayList<BillItem> itemList = bill.getItems();
		BillItem[] items = itemList.toArray(new BillItem[0]);
		
		double subtotal = BillCalculator.calcSubtotal(items);
		double tax = BillCalculator.calcTax(items);
		double tip = BillCalculator.calcTip(items);
		double total = BillCalculator.calcTotal(items);
		
		for (BillItem item : items) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subtotal + System.lineSeparator();
		text += "TAX - $" + tax + System.lineSeparator();
		text += "TIP - $" + tip + System.lineSeparator();
		text += "TOTAL - $" + total;
		
		return text;
	}
	
}
