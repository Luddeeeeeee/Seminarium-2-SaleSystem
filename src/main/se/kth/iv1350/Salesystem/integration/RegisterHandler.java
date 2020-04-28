package main.se.kth.iv1350.Salesystem.integration;

import main.se.kth.iv1350.Salesystem.model.Receipt;

/**
 * A handler for the cashregister.
 */
public class RegisterHandler {

	private int registertotal;
	
	public RegisterHandler() {
		registertotal = 1000;
	}
	
	/**
	 * Increases the amount of money in the register.
	 * 
	 * @param total The sale total to add to the registertotal.
	 */
	public void registerPayment(int total) {
		registertotal += total;
	}
	
	
	/**
	 * Prints the receipt from the printer.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.print(receipt.toString());
	}
}
