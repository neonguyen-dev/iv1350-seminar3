package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.Amount;
import java.lang.Math;

/**
 * Represents one payment for the Point-of-sale scenario.
 * The sale is payed with cash.
 */

public class CashPayment {
    private int paidAmount;
    private int total;

    /**
     * Creates a new instance. The customer handed over the cash in a specified amount.
     * 
     * @param paidAmount The amount of cash that was handed over to the cashier
     */
    public CashPayment(int paidAmount){
        this.paidAmount = paidAmount;
    }

    /**
     * Calculates the payment of the sale by rounding up.
     * 
     * @param amount The amount for the current sale
     */
    public void calculatePayment(Amount amount){
        total = Math.round(amount.getRunningTotal() + 0.5f);
    }

    /**
     * @return The amount of change to customer.
     */
    public float getChange(){
        return Math.subtractExact(paidAmount, total);
    }

    /**
     * @return The rounded up to pay in cash. 
     */
    public int getTotal(){
        return total;
    }
    
    /**
     * @return The amount of cash that was handed over to the cashier 
     */
    public int getPaidAmount(){
        return paidAmount;
    }
}
