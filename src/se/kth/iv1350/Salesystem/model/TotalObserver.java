package se.kth.iv1350.Salesystem.model;

/**
 * A observer interface that receives notifications about the total of a sale.
 * The class that is interested in such notifications implements this interface.
 */
public interface TotalObserver {

	/**
	 * Invoked whenever the running total has been updated.
	 * @param total The new total of the sale
	 */
	void newTotal(int total);
}
