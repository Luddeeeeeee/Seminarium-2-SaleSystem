package se.kth.iv1350.Salesystem.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.iv1350.Salesystem.model.ItemDTO;

public class ControllerTest {
	private Controller instanceToTest;
	
	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
		instanceToTest = new Controller();
	}

	@After
	public void tearDown() {
		instanceToTest = null;
	}

	@Test
	public void testStartSale() {
		instanceToTest.startSale();
	}
	
	@Test
	public void testAddItem() {
		instanceToTest.startSale();
		ItemDTO expResult = new ItemDTO(1111, 10, 0.12, "Beskrivning av vara 1" , "Varatyp 1");
		ItemDTO result = new ItemDTO(0,0,0,"","");
		result = instanceToTest.addItem(1111);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEndSale() {
		instanceToTest.startSale();
		instanceToTest.addItem(1111);
		int payment = 20;
		int expResult = 10;
		int result = instanceToTest.endSale(payment);
		assertEquals(expResult, result);
	}

}
