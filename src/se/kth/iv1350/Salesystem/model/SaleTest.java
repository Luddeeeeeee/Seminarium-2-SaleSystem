package se.kth.iv1350.Salesystem.model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {
	private Sale instanceToTest;
	
	@Before
	public void setUp() throws Exception {
		instanceToTest = new Sale();
	}

	@After
	public void tearDown() throws Exception {
		instanceToTest = null;
	}

	@Test
	public void testItemScannedMatch() {
		int identifier = 1111;
		instanceToTest.addItem(new ItemDTO(identifier, 10, 0.12, "Beskrivning av vara 1" , "Vara 1"));
		boolean expResult = true;
		boolean result = instanceToTest.itemScanned(identifier);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testItemScannedNoMatch() {
		instanceToTest.addItem(new ItemDTO(1111, 10, 0.12, "Beskrivning av vara 1" , "Vara 1"));
		int identifier = 1112;
		boolean expResult = false;
		boolean result = instanceToTest.itemScanned(identifier);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testUpdateQuantityMatch() {
		int identifier = 1111;
		instanceToTest.addItem(new ItemDTO(identifier, 10, 0.12, "Beskrivning av vara 1" , "Vara 1"));
		int expResult = 2;
		int result = 0;
		instanceToTest.updateQuantity(identifier);
		for(HashMap.Entry<ItemDTO, Integer> entry : instanceToTest.getItems().entrySet()) {
			if(1111 == entry.getKey().getIdentifier()) {
				result = entry.getValue();
			}
		}
		assertEquals(expResult, result);
	}
	
	@Test
	public void testUpdateQuantityNoMatch() {
		instanceToTest.addItem(new ItemDTO(1111, 10, 0.12, "Beskrivning av vara 1" , "Vara 1"));
		int identifier = 1112;
		int expResult = 1;
		int result = 0;
		instanceToTest.updateQuantity(identifier);
		for(HashMap.Entry<ItemDTO, Integer> entry : instanceToTest.getItems().entrySet()) {
			if(1111 == entry.getKey().getIdentifier()) {
				result = entry.getValue();
			}
		}
		assertEquals(expResult, result);
	}
	
	@Test
	public void testAddItem() {
		instanceToTest.addItem(new ItemDTO(1112, 15, 0.12, "Beskrivning av vara 2" , "Vara 2"));
		int expResult = 15;
		int result = instanceToTest.getTotal();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEndSale() {
		instanceToTest.addItem(new ItemDTO(1112, 15, 0.12, "Beskrivning av vara 2" , "Vara 2"));
		int payment = 20;
		int expResult = 5;
		int result = instanceToTest.endSale(payment);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testSaveReceipt() {
		Sale emptysale = new Sale();
		Receipt emptyreceipt = emptysale.getReceipt();
		instanceToTest.saveReceipt(instanceToTest, 20, 5);
		Receipt result = instanceToTest.getReceipt();
		assertNotEquals(emptyreceipt, result);
	}

}
