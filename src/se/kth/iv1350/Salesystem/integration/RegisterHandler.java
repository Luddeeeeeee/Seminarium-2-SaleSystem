package se.kth.iv1350.Salesystem.integration;

import se.kth.iv1350.Salesystem.model.Receipt;

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
	 * 
	 * @param receipt The receipt to print out.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.print(receipt.toString());
	}
}
