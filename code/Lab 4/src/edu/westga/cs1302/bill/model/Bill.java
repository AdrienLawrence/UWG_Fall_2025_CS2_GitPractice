package edu.westga.cs1302.bill.model;

import java.util.ArrayList;
import java.util.Arrays;

/** Stores information for a bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Bill {
	public static final double TIP_RATE = 0.2;
	public static final double TAX_RATE = 0.1;
	
	private BillItem[] items;
	private int size;
	
	/** Create a new empty Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Bill() {
		this.items = new BillItem[1];
		this.size = 0;
	}
	
	/** Adds the item to the bill
	 * 
	 * @precondition item != null
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 */
	public void addItem(BillItem item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		if (this.size >= this.items.length) {
			BillItem[] moreItems = new BillItem[this.size * 2];
			int moreSize = 0;
			for (BillItem currItem : this.items) {
				moreItems[moreSize] = currItem;
				moreSize++;
			}
			this.items = moreItems;
			this.size = moreSize;
		}
		this.items[this.size] = item;
		this.size++;
	}

	/** Returns the list of items in the bill
	 * 
	 * @precondition none
	 * @postconition none
	 * 
	 * @return the list of items in the bill
	 */
	public ArrayList<BillItem> getItems() {
		return new ArrayList<BillItem>(Arrays.asList(Arrays.copyOfRange(this.items, 0, this.size)));
	}

}
