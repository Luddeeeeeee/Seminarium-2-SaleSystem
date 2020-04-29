package se.kth.iv1350.Salesystem.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;


/**
 * This class represents the complete sale. All purchased items are handled with methods in this class.
 */
public class Sale {

	private String date;
	private LocalTime saleTime;
	private int total;
	private HashMap<ItemDTO,Integer> items;
	private Receipt receipt;
	
	public Sale() {
		this.total = 0;
		setTimeOfSale();
		receipt = new Receipt();
		this.items = new HashMap<ItemDTO,Integer>();
	}
	
	public HashMap<ItemDTO,Integer> getItems() {
		return items;
	}
	
	public int getTotal() {
		return total;
	}
	
	public LocalTime getSaleTime() {
		return saleTime;
	}
	
	public String getDate() {
		return date;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	
	/**
	 * Saves the time of the sale
	 */
	private void setTimeOfSale() {
		date = "29 APRIL 2020";
		saleTime = LocalTime.now();
		saleTime = saleTime.truncatedTo(ChronoUnit.SECONDS);
	}
	
	/**
	 * Checks if the specified Item has been entered in the sale previously.
	 * 
	 * @param identifier The ID of the item that should be compared.
	 * @return If the item has been entered before or not.
	 */
	public boolean itemScanned(int identifier) {
		boolean itemscanned = false;
		
		for(ItemDTO entry : items.keySet()) {
			if(identifier == entry.getIdentifier()) {
				itemscanned = true;
				break;
			}
		}
		return itemscanned;
	}
	
	/**
	 * Increases the quantity bought of the specified Item. Also increases total.
	 * 
	 * @param identifier The ID of the item to update the quantity of.
	 */
	public void updateQuantity(int identifier) {
		for(HashMap.Entry<ItemDTO, Integer> entry : items.entrySet()) {
			if(identifier == entry.getKey().getIdentifier()) {
				int currentvalue = entry.getValue();
				entry.setValue(currentvalue + 1);
				total += entry.getKey().getPrice();
				break;
			}
		}
	}

	/**
	 * Adds an item to the current sale. Increases total.
	 * 
	 * @param item The item to add to the sale.
	 */
	public void addItem(ItemDTO item) {
		items.put(item, 1);
		total += item.getPrice();
	}
	
	/**
	 * Calculates any change when customer pays.
	 * 
	 * @param payment The amount paid by the customer.
	 * @return The amount of change to give back to the customer.
	 */
	public int endSale(int payment) {
		int change = payment - total;
		return change;
	}
	
	/**
	 * Saves information about the sale to the receipt.
	 * 
	 * @param sale The sale to save to the receipt.
	 * @param payment The payment obtained from the customer.
	 * @param change The change to give back to the customer.
	 */
	public void saveReceipt(Sale sale, int payment, int change) {
		receipt.saveReceipt(sale, payment, change);
	}
}
