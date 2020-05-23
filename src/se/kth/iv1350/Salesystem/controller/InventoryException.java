package se.kth.iv1350.Salesystem.controller;

/**
 * Exception is thrown when a problem with the inventory occurs.
 */
@SuppressWarnings("serial")
public class InventoryException extends Exception {
	
	public InventoryException(String message, Throwable cause) {
		super(message + ", " + cause.getMessage());
	}
}
