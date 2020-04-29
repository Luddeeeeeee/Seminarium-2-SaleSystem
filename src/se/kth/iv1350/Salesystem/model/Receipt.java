package se.kth.iv1350.Salesystem.model;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * The class represents the receipt of the sale and makes the receipt that is printed at the end of a sale.
 */
public class Receipt {

	private HashMap<ItemDTO,Integer> items;
	private String date;
	private LocalTime saleTime;
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
	 * @param payment The payment obtained from the customer.
	 * @param change The change to give back to the customer.
	 */
	public void saveReceipt(Sale sale, int payment, int change) {
		items = sale.getItems();
		date = sale.getDate();
		saleTime = sale.getSaleTime();
		name = "IV1250 POS";
		adress = "Storeroad 4";
		total = sale.getTotal();
		for(HashMap.Entry<ItemDTO,Integer> entry : items.entrySet()) {
			totalVAT += entry.getKey().getPrice() * entry.getKey().getTaxRate();
		}
		this.payment = payment;
		this.change = change;
	}
	
	/**
	 * Converts the receipt to a String to print out.
	 */
	public String toString() {
		String receipt = "\n\n--------------- Receipt ---------------" 
						+ "\nName: " + name 
						+ "\nAdress: " + adress 
						+ "\nDate: " + date 
						+ "\nTime: " + saleTime 
						+ "\n--------------------------------------"
						+ "\nName\t\tQuantity\tPrice" + mapToString(items)
						+ "\n--------------------------------------"
						+ "\nTotal: \t\t\t\t" + Integer.toString(total)
						+ "\n\nTotalVAT: \t\t\t" + Double.toString(totalVAT)
						+ "\n\nCash: \t\t\t\t" + Integer.toString(payment)
						+ "\n\nChange: \t\t\t" + Integer.toString(change)
						+ "\n------------ Receipt end -------------";
		
		return receipt;
	}
	
	private String mapToString(HashMap<ItemDTO, Integer> maptoconvert) {
		StringBuilder mapAsString = new StringBuilder("");
		for(HashMap.Entry<ItemDTO,Integer> entry : items.entrySet()) {
			mapAsString.append("\n" + entry.getKey().getName() + "\t" + entry.getValue() + "\t\t" + entry.getKey().getPrice());
		}
		return mapAsString.toString();
	}
	
}
