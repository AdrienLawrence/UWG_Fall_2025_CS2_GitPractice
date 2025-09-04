package edu.westga.cs1302.lab2.tests.view.bill_view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.Bill;
import edu.westga.cs1302.javafx_sample_starter.model.BillItem;
import edu.westga.cs1302.javafx_sample_starter.views.BillView;

class TestGetText {
	
	@Test
	public void billItemsTest() {
		Bill bill = new Bill();
		
		BillItem item1 = new BillItem("Item1", 2.50);
		BillItem item2 = new BillItem("Item2", 3.50);
		
		bill.addItem(item1);
		bill.addItem(item2);
		
		BillView view = new BillView();
		String result = view.getText(bill);
		
		assertTrue(result.contains("Item2"));
		assertTrue(result.contains("Item1"));
		assertTrue(result.contains("2.50"));
		assertTrue(result.contains("3.50"));
		
	}
	
	@Test
	public void totalsTest() {
		Bill bill = new Bill();
		
		BillItem item1 = new BillItem("Item1", 2.50);
		BillItem item2 = new BillItem("Item2", 3.50);
		
		bill.addItem(item1);
		bill.addItem(item2);
		
		BillView view = new BillView();
		String result = view.getText(bill);
		
		//1.3 = 1 (subtotal) + .1 (tax) + .2 (tip)
		double total = (2.50 + 3.50) * 1.30;
		
		//Assuming doubles are represented like this
		assertTrue(result.contains("SUBTOTAL - $6.0"));
		assertTrue(result.contains("TOTAL - $" + total));
	}
	
	@Test
	public void emptyBillTest() {
		Bill bill = new Bill();
		
		BillView view = new BillView();
		String result = view.getText(bill);
		
		assertTrue(result.contains("SUBTOTAL - $0.0"));
		assertTrue(result.contains("TOTAL - $0.0"));
	}

}
