package main.se.kth.iv1350.Salesystem.model;


/**
 * An ItemDTO which contains all attributes of a item in the sale.
 */
public class ItemDTO {

	private int identifier;
	private int price;
	private double taxRate;
	private String description; 
	private String name;
	
	public ItemDTO(int identifier, int price, double taxRate, String description, String name) {
		this.identifier = identifier;
		this.price = price;
		this.taxRate = taxRate;
		this.description = description;
		this.name = name;
	}

	public int getIdentifier() {
		return identifier;
	}

	public int getPrice() {
		return price;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	
	public String getName() {
		return name;
	}
	
}
