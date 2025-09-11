package edu.westga.cs1302.bill.model;

/** Stores information for a single item on a bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillItem {
	private final String name;
	private final double amount;
	
	/** create a new bill item with the provided name and amount
	 * 
	 * @precondition name != null &&
	 * 				 amount > 0
	 * @postcondition getName() == name &&
	 * 				  getAmount() == amount
	 * 
	 * @param name the name of the bill item
	 * @param amount the amount (cost) of the bill item
	 */
	public BillItem(String name, double amount) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be positive, but was " + amount);
		}
		this.name = name;
		this.amount = amount;
	}

	/** Return the name for the bill item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the bill item
	 */
	public String getName() {
		return this.name;
	}

	/** Return the amount for the bill item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the amount for the bill item
	 */
	public double getAmount() {
		return this.amount;
	}
}
