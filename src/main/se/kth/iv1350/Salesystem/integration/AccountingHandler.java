package main.se.kth.iv1350.Salesystem.integration;

import java.util.ArrayList;

import main.se.kth.iv1350.Salesystem.model.Sale;

/**
 * A handler for the Accounting database. 
 */
public class AccountingHandler {

	private ArrayList<Sale> salelog;
	

	public void logAccounting(Sale sale) {
		salelog.add(sale);
	}
}
