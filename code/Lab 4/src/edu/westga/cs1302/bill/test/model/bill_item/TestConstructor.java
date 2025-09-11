package edu.westga.cs1302.bill.test.model.bill_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillItem;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new BillItem(null, 1);});
	}

	@Test
	void testAmountTooLow() {
		assertThrows(IllegalArgumentException.class, ()->{new BillItem("name", 0);});
	}
	
	@Test
	void testValindNameAndAmount() {
		BillItem result = new BillItem("name", 1);
		
		assertEquals("name", result.getName(), "checking the name of the bill item");
		assertEquals(1, result.getAmount(), "checking the amount of the bill item");
	}

}
