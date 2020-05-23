package se.kth.iv1350.Salesystem.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemRegistryHandlerTest {
	private ItemRegistryHandler instanceToTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instanceToTest = new ItemRegistryHandler();
	}

	@After
	public void tearDown() throws Exception {
		instanceToTest = null;
	}

	@Test
	public void testIllegalIdentifierException() {
		try {
			instanceToTest.getItem(2222);
			fail("Illegal Identifier did not throw exception");
		} catch (IllegalIdentifierException | NetworkException e) {
			assertTrue(e.getMessage().contains("Okänd Varu ID"));
		}
	}
	
	@Test
	public void testNetworkException() {
		try {
			instanceToTest.getItem(9999);
			fail("Network error did not throw exception");
		} catch (IllegalIdentifierException | NetworkException e) {
			assertTrue(e.getMessage().contains("Databasen går inte att nå"));
		}
	}

}
