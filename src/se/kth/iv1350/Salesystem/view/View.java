package se.kth.iv1350.Salesystem.view;

import se.kth.iv1350.Salesystem.controller.Controller;

/**
 * The class that represents the view of this application.
 */
public class View {

	private Controller contr;
	
	public View(Controller contr) {
		this.contr = contr;
	}
	
	/**
	 * Calls all systemoperations in the controller by performing a fake sale.
	 */
	public void runFakeExecution() {
		contr.startSale();
		System.out.print("A new sale has been started.");
		contr.addItem(1111);
		contr.addItem(1113);
		contr.addItem(1111);
		contr.endSale(100);
	}
}
