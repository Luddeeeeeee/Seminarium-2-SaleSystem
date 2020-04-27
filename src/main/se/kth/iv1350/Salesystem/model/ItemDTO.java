/**
 * 
 */
package main.se.kth.iv1350.Salesystem.model;

/**
 * An ItemDTO which contains all attributes of a item in the sale.
 */
public class ItemDTO {

	private int price;
	private int taxRate;
	private String description; 
	private String name;
	
	public ItemDTO(int price, int taxRate, String description, String name) {
		this.price = price;
		this.taxRate = taxRate;
		this.description = description;
		this.name = name;
	}
}
