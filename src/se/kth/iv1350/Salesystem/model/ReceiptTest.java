package se.kth.iv1350.Salesystem.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReceiptTest {
	private Receipt instanceToTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instanceToTest = new Receipt();
	}

	@After
	public void tearDown() throws Exception {
		instanceToTest = null;
	}

	@Test
	public void testSaveReceipt() {
		Sale sale = new Sale();
		Receipt emptyReceipt = new Receipt();
		instanceToTest.saveReceipt(sale, 20, 20);
		assertNotEquals(emptyReceipt, instanceToTest);
	}

}
