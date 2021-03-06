package se.kth.iv1350.Salesystem.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.Salesystem.controller.Controller;

public class ViewTest {
	private View instanceToTest;

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
		instanceToTest.runFakeExecution();
	}

}
