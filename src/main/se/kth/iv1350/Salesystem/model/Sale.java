/**
 * 
 */
package main.se.kth.iv1350.Salesystem.model;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * This class represents the complete sale. All purchased items are handled with methods in this class.
 */
public class Sale {

	private long saleTime;
	private int total;
	private HashMap<ItemDTO,Integer> items;
	
	public Sale() {
		this.total = 0;
		setTimeOfSale();
		Receipt receipt = new Receipt();
	}
	
	/**
	 * Saves the time of the sale
	 */
	private void setTimeOfSale() {
		saleTime = System.currentTimeMillis();
	}
}
