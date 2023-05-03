package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.model.Sale;

/**
 * Represents the external accounting system
 */
public class AccountingSystem {
    float balance;

    /**
     * Creates a new instance of the accounting system.
     * @param balance The given balance in the accounting system.
     */
    public AccountingSystem(float balance){
        this.balance = balance; 
    }

    /**
     * Updates the accounting system in accordance with the finished sale.
     * @param sale The sale that has been logged and paid for.
     */
    public void updateAccountingSystem(Sale sale){
        balance += sale.getAmount().getRunningTotal();
    }
}
