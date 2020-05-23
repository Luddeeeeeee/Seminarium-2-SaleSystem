package se.kth.iv1350.Salesystem.view;

import se.kth.iv1350.Salesystem.model.TotalObserver;

/**
 * Represents a display that shows the runnung total of the ongoing sale.
 */
public class TotalRevenueView implements TotalObserver{
	private int total;
	
	/**
	 * Creates a new instance with all variables set to 0.
	 */
	public TotalRevenueView() {
		total = 0;
	}
	
	@Override
	public void newTotal(int newTotal) {
		updateTotal(newTotal);
		printCurrentState();
	}
	
	private void updateTotal(int newTotal) {
		total += newTotal;
	}
	
	private void printCurrentState() {
		System.out.println("För användare: Current total Display: " + this.total);
	}

}
