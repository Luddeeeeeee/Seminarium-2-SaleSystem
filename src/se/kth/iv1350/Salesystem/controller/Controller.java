package se.kth.iv1350.Salesystem.controller;

import se.kth.iv1350.Salesystem.integration.AccountingHandler;
import se.kth.iv1350.Salesystem.integration.IllegalIdentifierException;
import se.kth.iv1350.Salesystem.integration.ItemRegistryHandler;
import se.kth.iv1350.Salesystem.integration.NetworkException;
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
	private ItemRegistryHandler itemreghandler;
	
	public Controller() {
		reghandler = new RegisterHandler();
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
	 * @throws InventoryException when the database cannot be reached.
	 */
	public ItemDTO addItem(int identifier) throws IllegalIdentifierException, InventoryException {
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
				 throw new InventoryException("Inventory failure", ne);
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
		AccountingHandler.getInstance().logAccounting(sale);
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
