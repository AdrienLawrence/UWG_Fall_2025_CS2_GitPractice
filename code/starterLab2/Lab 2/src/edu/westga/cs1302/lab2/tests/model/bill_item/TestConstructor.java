package edu.westga.cs1302.lab2.tests.model.bill_item;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.BillItem;

class TestConstructor {
	
	@Test
	public void itemTest() {
		
		BillItem item = new BillItem("item", 2.50);
		
		assertEquals(2.50, item.getAmount());
		assertEquals("item", item.getName());
	}
	
	@Test
	public void nullNameTest() {
		
		assertThrows(IllegalArgumentException.class, () -> new BillItem(null, 9.40));
		
	}
	
	@Test
	public void negativeAmount() { 
		
		assertThrows(IllegalArgumentException.class, () -> new BillItem("item", -3.50));
	}
	
	@Test
	public void zeroAmount() {
		
		assertThrows(IllegalArgumentException.class, () -> new BillItem("item", 0));
		
	}

}
