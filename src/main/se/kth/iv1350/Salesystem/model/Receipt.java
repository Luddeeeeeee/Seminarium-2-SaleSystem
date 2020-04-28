package main.se.kth.iv1350.Salesystem.model;

import java.util.HashMap;

/**
 * The class represents the receipt of the sale and makes the receipt that is printed at the end of a sale.
 */
public class Receipt {

	private HashMap<ItemDTO,Integer> items;
	private long saleTime;
	private String name;
	private String adress;
	private int total;
	private double totalVAT = 0;
	private int payment;
	private int change;
	
	protected Receipt(){
		
	}

	/**
	 * Saves most information of the sale to the receipt.
	 * 
	 * @param sale The current sale.
	 */
	public void saveReceipt(Sale sale, int payment, int change) {
		items = sale.getItems();
		saleTime = sale.getSaleTime();
		name = "GroceryStore";
		adress = "Storeroad 4";
		total = sale.getTotal();
		for(HashMap.Entry<ItemDTO,Integer> entry : items.entrySet()) {
			totalVAT += entry.getKey().getPrice() * entry.getKey().getTaxRate();
		}
		this.payment = payment;
		this.change = change;
	}
	
	
}
