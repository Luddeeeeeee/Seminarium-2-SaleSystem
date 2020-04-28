package main.se.kth.iv1350.Salesystem.controller;

import main.se.kth.iv1350.Salesystem.integration.AccountingHandler;
import main.se.kth.iv1350.Salesystem.integration.RegisterHandler;
import main.se.kth.iv1350.Salesystem.model.ItemDTO;
import main.se.kth.iv1350.Salesystem.model.Receipt;
import main.se.kth.iv1350.Salesystem.model.Sale;
import main.se.kth.iv1350.Salesystem.util.ItemID;
import main.se.kth.iv1350.Salesystem.integration.ItemRegistryHandler;

/**
 * This is the applications only controller. All calls for the model passes through here.
 */
public class Controller {

	private Sale sale;
	private RegisterHandler reghandler;
	private AccountingHandler acchandler;
	private ItemRegistryHandler itemreghandler;
	
	public Controller() {
		reghandler = new RegisterHandler();
		acchandler = new AccountingHandler();
		itemreghandler = new ItemRegistryHandler();
	}
	
	/**
	 * Starts a new sale
	 */
	public void startSale() {
		sale = new Sale();
	}
	
	/**
	 * Adds an item to the current sale.
	 * 
	 * @param identifier The ItemID of the item to add.
	 * @return
	 */
	public ItemDTO addItem(ItemID identifier) {
		ItemDTO item = null;
		if(sale.itemScanned(identifier)) {
			sale.updateQuantity(identifier);
		}
		else {
			item = itemreghandler.getItem(identifier);
			sale.addItem(item);
		}
		return item;
	}
	
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
}
