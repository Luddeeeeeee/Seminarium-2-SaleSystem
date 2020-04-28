package main.se.kth.iv1350.Salesystem.integration;

import java.util.HashMap;

import main.se.kth.iv1350.Salesystem.model.ItemDTO;
import main.se.kth.iv1350.Salesystem.util.ItemID;

/**
 * A handler for the itemRegistry.
 */
public class ItemRegistryHandler {

	private HashMap<ItemDTO,Integer> itemregistry;
	
	public ItemRegistryHandler() {
		itemregistry = new HashMap<ItemDTO,Integer>();
		itemregistry.put(new ItemDTO(new ItemID(1111), 10, 0.125, "Beskrivning av vara 1" , "Vara 1"), 10);
		itemregistry.put(new ItemDTO(new ItemID(1112), 15, 0.125, "Beskrivning av vara 2", "Vara 2"), 20);
		itemregistry.put(new ItemDTO(new ItemID(1113), 20, 0.25, "Beskrivning av vara 3", "Vara 3"), 15);
	}
	
	/**
	 * Fetches an Item from the ItemRegistry.
	 * 
	 * @param identifier The identifier of the Item to fetch.
	 * @return The searched Item.
	 */
	public ItemDTO getItem(ItemID identifier) {
		ItemDTO item = null;
		for(HashMap.Entry<ItemDTO, Integer> entry : itemregistry.entrySet()) {
			if(identifier == entry.getKey().getIdentifier()) {
				item = entry.getKey();
				break;
			}
		}
		return item;
	}
	
	/**
	 * Updates the inventory database with the items in the sale.
	 * 
	 * @param items The list of items and bought in the sale including they're quantity.
	 */
	public void updateInventory(HashMap<ItemDTO, Integer> items) {
		for(HashMap.Entry<ItemDTO, Integer> itemtoremove : items.entrySet()) {
			for(HashMap.Entry<ItemDTO, Integer> entry : itemregistry.entrySet()) {
				if(itemtoremove.getKey() == entry.getKey()) {
					int currentinventory = entry.getValue();
					entry.setValue(currentinventory - itemtoremove.getValue());
					break;
				}
			}
		}
	}
}
