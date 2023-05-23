package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.model.CashPayment;
import se.kth.iv1350.seminar3.model.SaleObserver;

/**
 * Observer responsible for total revenue in View.
 */
public class TotalRevenueView implements SaleObserver{
    float totalSale = 0;

    /**
     * Adds total sale value and prints the total cost since program started.
     * 
     * @param payment Payment of the whole sale.
     */
    public void newSale(CashPayment payment){
        totalSale += payment.getTotal();
        System.out.println("\nTotal cost since program started: " + totalSale + "\n");
    }
}
