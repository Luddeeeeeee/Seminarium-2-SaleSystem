package se.kth.iv1350.Salesystem.startup;

import org.junit.Test;

import se.kth.iv1350.Salesystem.controller.Controller;
import se.kth.iv1350.Salesystem.view.View;

public class MainTest {

	@SuppressWarnings("unused")
	@Test
	public void testMain() {
		Controller contr = new Controller();
		View view = new View(contr);
	}

}
