package se.kth.iv1350.Salesystem.integration;

import java.util.ArrayList;

import se.kth.iv1350.Salesystem.model.Sale;

/**
 * A handler for the Accounting database. 
 */
public class AccountingHandler {

	private ArrayList<Sale> salelog;
	

	public AccountingHandler() {
		salelog = new ArrayList<Sale>();
	}
	
	public void logAccounting(Sale sale) {
		salelog.add(sale);
	}
}
