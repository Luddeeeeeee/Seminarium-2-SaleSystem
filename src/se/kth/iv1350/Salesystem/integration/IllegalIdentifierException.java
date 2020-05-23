package se.kth.iv1350.Salesystem.integration;

/**
 * Exception is thrown when the user inserts a Identifier that is not supported or existant.
 */
@SuppressWarnings("serial")
public class IllegalIdentifierException extends Exception {

	public IllegalIdentifierException(String message) {
		super(message);
	}

}
