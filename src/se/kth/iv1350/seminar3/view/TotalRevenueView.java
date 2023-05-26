package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.model.SaleObserver;

/**
 * Observer responsible for total revenue in View.
 */
public class TotalRevenueView implements SaleObserver{
    int totalSale = 0;

    /**
     * Adds total sale value and prints the total cost since program started.
     * 
     * @param total Total sale value of the sale.
     */
    public void newSale(int total){
        totalSale += total;
        System.out.println("\nTotal cost since program started: " + totalSale + "\n");
    }
}
