package se.kth.iv1350.Salesystem.integration;

import java.util.ArrayList;

import se.kth.iv1350.Salesystem.model.Sale;

/**
 * A handler for the Accounting database. 
 */
public class AccountingHandler {

	private static AccountingHandler onlyInstance;
	private ArrayList<Sale> salelog;
	

	public AccountingHandler() {
		salelog = new ArrayList<Sale>();
	}
	
	public static AccountingHandler getInstance() {
		if(onlyInstance == null)
			onlyInstance = new AccountingHandler();
		return onlyInstance;
	}
	
	public void logAccounting(Sale sale) {
		salelog.add(sale);
	}
}
