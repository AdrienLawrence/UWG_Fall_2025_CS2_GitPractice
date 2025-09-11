package edu.westga.cs1302.bill.model;

import edu.westga.cs1302.bill.view.BillView;
import edu.westga.cs1302.bill.model.Bill;

/** Calculates Bill totals
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {	
	
	public static double calcSubtotal(Bill bill) {
		
		double subTotal = 0.0;
		
		for (BillItem item : bill.getItems()) {
			subTotal += item.getAmount();
		}
		
		return BillCalculator.roundToNearestHundredth(subTotal);
	}
	
	public static double calcTax(Bill bill) {
		
		double tax = 0.0;
		
		for (BillItem item : bill.getItems()) {
			tax += item.getAmount() * Bill.TAX_RATE;
		}
		
		return BillCalculator.roundToNearestHundredth(tax);
	}
	
	public static double calcTip(Bill bill) {
		
		double tip = 0.0;
		
		for (BillItem item : bill.getItems()) {
			tip += item.getAmount() * Bill.TIP_RATE;
		}
		
		return BillCalculator.roundToNearestHundredth(tip);
	}
	
	public static double calcTotal(Bill bill) {
		
		double total = 0.0;
		
		for (BillItem item : bill.getItems()) {
			total += item.getAmount() + (item.getAmount() * Bill.TAX_RATE) + (item.getAmount() * Bill.TIP_RATE);
		}
		
		return BillCalculator.roundToNearestHundredth(total);
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
	
}
