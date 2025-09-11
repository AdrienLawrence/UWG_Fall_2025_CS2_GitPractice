package edu.westga.cs1302.bill.model;

/** Calculates Bill totals
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {	
	
	/** Returns an aggregate of amounts
	 * for the items in the Bill
	 * 
	 * @precondition None
	 * @postcondition None
	 * 
	 * @param items in the Bill
	 * @return subtotal for items
	 */
	public static double calcSubtotal(BillItem[] items) {
		
		double subTotal = 0.0;
		
		for (BillItem item : items) {
			subTotal += item.getAmount();
		}
		
		return BillCalculator.roundToNearestHundredth(subTotal);
	}
	
	/** Returns an aggregate tax for the items 
	 * in the bill
	 * 
	 * @precondition None
	 * @postcondition None
	 * 
	 * @param items in the Bill
	 * @return taxes for the bill
	 */
	public static double calcTax(BillItem[] items) {
		
		double tax = 0.0;
		
		for (BillItem item : items) {
			tax += item.getAmount() * Bill.TAX_RATE;
		}
		
		return BillCalculator.roundToNearestHundredth(tax);
	}
	
	/** Returns an Aggregate tip for items
	 * in the Bill
	 * 
	 * @precondition None
	 * @postcondition None
	 * 
	 * @param items in the Bill
	 * @return Tip on the Bill
	 */
	public static double calcTip(BillItem[] items) {
		
		double tip = 0.0;
		
		for (BillItem item : items) {
			tip += item.getAmount() * Bill.TIP_RATE;
		}
		
		return BillCalculator.roundToNearestHundredth(tip);
	}
	
	/** Returns the total aggregate cost of 
	 * the bill with taxes, tip, and item amounts
	 * 
	 * @precondition None
	 * @postcondition None
	 * 
	 * @param items in the Bill
	 * @return Total including subtotal, taxes, and tip
	 */
	public static double calcTotal(BillItem[] items) {
		
		double total = 0.0;
		
		for (BillItem item : items) {
			total += item.getAmount() + (item.getAmount() * Bill.TAX_RATE) + (item.getAmount() * Bill.TIP_RATE);
		}
		
		return BillCalculator.roundToNearestHundredth(total);
	}
	
	/* Note: I could've reused calcSubtotal for other methods 
	 * but that creates dependencies that would make 
	 * debugging harder with mixed logic
	 */
		
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
	
}
