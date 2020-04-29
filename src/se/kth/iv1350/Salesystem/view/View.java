package se.kth.iv1350.Salesystem.view;

import se.kth.iv1350.Salesystem.controller.Controller;
import se.kth.iv1350.Salesystem.model.ItemDTO;

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
		System.out.println("A new sale has been started.");
		ItemDTO item1 = contr.addItem(1111);
		System.out.println("Added item: " + item1.toString() + ", Current total: " + contr.getSale().getTotal());
		ItemDTO item2 = contr.addItem(1113);
		System.out.println("Added item: " + item2.toString() + ", Current total: " + contr.getSale().getTotal());
		ItemDTO item3 = contr.addItem(1111);
		System.out.println("Added item: " + item3.toString() + ", Current total: " + contr.getSale().getTotal());
		ItemDTO item4 = contr.addItem(1112);
		System.out.println("Added item: " + item4.toString() + ", Current total: " + contr.getSale().getTotal());
		contr.endSale(100);
		System.out.println("Sale Finished");
	}
}
