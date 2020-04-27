package main.se.kth.iv1350.Salesystem.controller;

import main.se.kth.iv1350.Salesystem.integration.AccountingHandler;
import main.se.kth.iv1350.Salesystem.integration.RegisterHandler;
import main.se.kth.iv1350.Salesystem.model.ItemDTO;
import main.se.kth.iv1350.Salesystem.model.Sale;
import main.se.kth.iv1350.Salesystem.util.ItemID;
import main.se.kth.iv1350.Salesystem.integration.ItemRegistryHandler;

/**
 * This is the applications only controller. All calls for the model passes through here.
 */
public class Controller {

	/**
	 * 
	 */
	public Controller() {
		RegisterHandler regHandler = new RegisterHandler();
		AccountingHandler accHandler = new AccountingHandler();
		ItemRegistryHandler itemregHandler = new ItemRegistryHandler();
	}
	
	/**
	 * Starts a new sale
	 */
	public void startSale() {
		Sale sale = new Sale();
	}
	
	/**
	 * Adds an item to the current sale.
	 * 
	 * @param identifier The ItemID of the item to add.
	 * @return
	 */
	public ItemDTO addItem(ItemID identifier) {
		
		
		
	}
}
