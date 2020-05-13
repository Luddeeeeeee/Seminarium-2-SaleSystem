package se.kth.iv1350.Salesystem.view;

import se.kth.iv1350.Salesystem.controller.Controller;
import se.kth.iv1350.Salesystem.exceptions.IllegalIdentifierException;
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
		}catch(IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		try {
			ItemDTO item1 = contr.addItem(1111);
			System.out.println("För användare: Added item: " + item1.toString());
		}catch(IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		try {
			ItemDTO item2 = contr.addItem(1113);
			System.out.println("För användare: Added item: " + item2.toString());
		} catch (IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		try {
			ItemDTO item3 = contr.addItem(1213);
			System.out.println("För användare: Added item: " + item3.toString());
		} catch (IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		
		try {
			ItemDTO item4 = contr.addItem(1111);
			System.out.println("För användare: Added item: " + item4.toString());
		} catch (IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		try {
			ItemDTO item5 = contr.addItem(1112);
			System.out.println("För användare: Added item: " + item5.toString());
		} catch (IllegalIdentifierException iie) {
			System.out.println("För Användare: " + iie.getMessage());
			System.out.print("För Loggen: ");
			iie.printStackTrace();
		}
		
		
		contr.endSale(100);
		System.out.println("För användare: Sale Finished");
	}
}
