package se.kth.iv1350.seminar3;

import se.kth.iv1350.seminar3.model.Sale;

/**
 * Observer for sale
 */
public interface SaleObserver {
    /**
     * Invoked when a sale has been finalized.
     */
    public void newSale(Sale sale);
}
