package edu.westga.cs1302.bill.test.model.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;

class TestAddItem {

	@Test
	void testNullItem() {
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, ()->{bill.addItem(null);});
	}

	@Test
	void testAddToEmptyBill() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 1);
		
		bill.addItem(item1);
		
		assertEquals(1, bill.getItems().size(), "checking number of bill items");
		assertEquals("orange", bill.getItems().get(0).getName(), "checking name of the first bill item");
		assertEquals(1, bill.getItems().get(0).getAmount(), "checking amount of the first bill item");
	}

	@Test
	void testAddToNonEmptyBill() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 1);
		bill.addItem(item1);
		BillItem item2 = new BillItem("banana", 2);
		
		bill.addItem(item2);
		
		assertEquals(2, bill.getItems().size(), "checking number of bill items");
		assertEquals("orange", bill.getItems().get(0).getName(), "checking name of the first bill item");
		assertEquals(1, bill.getItems().get(0).getAmount(), "checking amount of the first bill item");
		assertEquals("banana", bill.getItems().get(1).getName(), "checking name of the second bill item");
		assertEquals(2, bill.getItems().get(1).getAmount(), "checking amount of the second bill item");
	}

}
