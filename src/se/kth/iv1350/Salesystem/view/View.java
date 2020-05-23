package se.kth.iv1350.Salesystem.view;

import se.kth.iv1350.Salesystem.controller.Controller;
import se.kth.iv1350.Salesystem.controller.InventoryException;
import se.kth.iv1350.Salesystem.integration.IllegalIdentifierException;
import se.kth.iv1350.Salesystem.model.ItemDTO;

/**
 * The class that represents the view of this application.
 */
public class View {

	private Controller contr;
	
	public View(Controller contr) {
		this.contr = contr;
		contr.addTotalObserver(new TotalRevenueView());
	}
	
	/**
	 * Calls all systemoperations in the controller by performing a fake sale.
	 */
	public void runFakeExecution() {
		contr.startSale();
		System.out.println("För användare: A new sale has been started.");
		
		try {
			contr.addItem(9999);
		}catch(IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		try {
			ItemDTO item1 = contr.addItem(1111);
			System.out.println("För användare: Added item: " + item1.toString() + ", Sale total: " + contr.getSale().getTotal());
		}catch(IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		try {
			ItemDTO item2 = contr.addItem(1113);
			System.out.println("För användare: Added item: " + item2.toString() + ", Sale total: " + contr.getSale().getTotal());
		} catch (IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		try {
			ItemDTO item3 = contr.addItem(1213);
			System.out.println("För användare: Added item: " + item3.toString() + ", Sale total: " + contr.getSale().getTotal());
		} catch (IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		
		try {
			ItemDTO item4 = contr.addItem(1111);
			System.out.println("För användare: Added item: " + item4.toString() + ", Sale total: " + contr.getSale().getTotal());
		} catch (IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		try {
			ItemDTO item5 = contr.addItem(1112);
			System.out.println("För användare: Added item: " + item5.toString() + ", Sale total: " + contr.getSale().getTotal());
		} catch (IllegalIdentifierException | InventoryException iie) {
			System.out.println("För Användare: " + iie.getMessage());
		}
		
		
		contr.endSale(100);
		System.out.println("För användare: Sale Finished");
	}
}
