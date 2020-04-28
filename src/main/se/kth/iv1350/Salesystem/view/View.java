package main.se.kth.iv1350.Salesystem.view;

import main.se.kth.iv1350.Salesystem.controller.Controller;
import main.se.kth.iv1350.Salesystem.util.ItemID;

/**
 * The class that represents the view of this application.
 */
public class View {

	private Controller contr;
	
	public View(Controller contr) {
		this.contr = contr;
	}
	
	public void programRun() {
		contr.startSale();
		contr.addItem(new ItemID(1111));
		contr.addItem(new ItemID(1113));
		contr.addItem(new ItemID(1111));
		contr.endSale(100);
	}
}
