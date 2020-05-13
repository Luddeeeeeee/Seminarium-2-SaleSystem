package se.kth.iv1350.Salesystem.controller;

import se.kth.iv1350.Salesystem.exceptions.IllegalIdentifierException;
import se.kth.iv1350.Salesystem.exceptions.NetworkException;
import se.kth.iv1350.Salesystem.integration.AccountingHandler;
import se.kth.iv1350.Salesystem.integration.ItemRegistryHandler;
import se.kth.iv1350.Salesystem.integration.RegisterHandler;
import se.kth.iv1350.Salesystem.model.ItemDTO;
import se.kth.iv1350.Salesystem.model.Receipt;
import se.kth.iv1350.Salesystem.model.Sale;
import se.kth.iv1350.Salesystem.model.TotalObserver;

/**
 * This is the applications only controller. All calls for the model passes through here.
 */
public class Controller {

	private TotalObserver totalObserver;
	private Sale sale;
	private RegisterHandler reghandler;
	private AccountingHandler acchandler;
	private ItemRegistryHandler itemreghandler;
	
	public Controller() {
		reghandler = new RegisterHandler();
		acchandler = new AccountingHandler();
		itemreghandler = new ItemRegistryHandler();
	}
	
	public Sale getSale() {
		return sale;
	}
	
	/**
	 * Starts a new sale. And adds observers to the sale.
	 */
	public void startSale() {
		sale = new Sale();
		sale.addTotalObserver(totalObserver);
	}
	
	/**
	 * Adds an item to the current sale.
	 * 
	 * @param identifier The ItemID of the item to add.
	 * @return The added item.
	 * @throws IllegalIdentifierException when the inserted Item Identifier is not supported by the Itemregistry.
	 */
	public ItemDTO addItem(int identifier) throws IllegalIdentifierException{
		ItemDTO item = null;
		if(sale.itemScanned(identifier)) {
			item = sale.updateQuantity(identifier);
		}
		else {
			try {
				item = itemreghandler.getItem(identifier);
				sale.addItem(item);
			} 
			 catch (NetworkException ne) {
				 System.out.print("För Loggen: ");
				 ne.printStackTrace();
			}
		}
		return item;
	}
	
	/**
	 * Ends the ongoing sale.
	 * 
	 * @param payment The amount paid by the customer.
	 * @return Any change to give back to the customer.
	 */
	public int endSale(int payment) {
		itemreghandler.updateInventory(sale.getItems());
		acchandler.logAccounting(sale);
		int change = sale.endSale(payment);
		sale.saveReceipt(sale, payment, change);
		reghandler.registerPayment(sale.getTotal());
		Receipt receipt = sale.getReceipt();
		reghandler.printReceipt(receipt);
		
		return change;
	}

	/**
	 * Adds a Observer of the running total.
	 * @param totalObserver The Observer to add.
	 */
	public void addTotalObserver(TotalObserver totalObserver) {
		this.totalObserver = totalObserver;
	}
}
