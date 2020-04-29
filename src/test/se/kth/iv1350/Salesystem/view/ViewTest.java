package test.se.kth.iv1350.Salesystem.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.se.kth.iv1350.Salesystem.controller.Controller;
import main.se.kth.iv1350.Salesystem.view.View;

public class ViewTest {
	private View instanceToTest;
	
	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
		Controller contr = new Controller();
		instanceToTest = new View(contr);
	}

	@After
	public void tearDown() {
		instanceToTest = null;
	}

	@Test
	public void testRunFakeExecution() {
		
	}

}
