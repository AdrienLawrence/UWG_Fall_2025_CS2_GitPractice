package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {
	
	@Test
	public void singleItemTest() {
		Bill bill = new Bill();
		BillItem item = new BillItem("Item", 10.99);
		
		bill.addItem(item);
		
		assertEquals(1, bill.getItems().size());
		assertEquals("Item", bill.getItems().get(0).getName());
		assertEquals(10.99, bill.getItems().get(0).getAmount(), .001);
	}
	
	@Test
	public void multItemTest() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Item1", 12.99);
		BillItem item2 = new BillItem("Item2", 2.99);
		BillItem item3 = new BillItem("Item3", 3.49);
		
		bill.addItem(item1);
		bill.addItem(item2);
		bill.addItem(item3);
		
		assertEquals(3, bill.getItems().size());
		assertEquals("Item2", bill.getItems().get(1).getName());
		assertEquals(3.49, bill.getItems().get(2).getAmount(), .001);
		
	}
	
	@Test
	public void nullTest() {
		Bill bill = new Bill();
		
		assertThrows(IllegalArgumentException.class, () -> bill.addItem(null));
	}
	
	@Test
	public void stressTest() {
		Bill bill = new Bill();
		for (int ind = 0; ind < 10000; ind++) {
			if (ind == 5974) {
				BillItem key = new BillItem("key", 9.50);
				bill.addItem(key);
			} else {
				BillItem item = new BillItem("item", 5.00);
				bill.addItem(item);
			}
		}
		
		assertEquals("key", bill.getItems().get(5974).getName());
		assertEquals(9.50, bill.getItems().get(5974).getAmount(), .001);
		assertEquals(10000, bill.getItems().size());
	}
	
	@Test
	public void dupeItemTest() {
		Bill bill = new Bill();
		BillItem item = new BillItem("item", 2.50);
		
		bill.addItem(item);
		bill.addItem(item);
		
		assertEquals(2, bill.getItems().size());
		assertEquals(item, bill.getItems().get(0));
		assertEquals(item, bill.getItems().get(1));
	}

}
