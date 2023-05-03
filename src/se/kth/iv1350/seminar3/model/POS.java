package se.kth.iv1350.seminar3.model;

import java.util.ArrayList;

/**
 * The POS system that is responsible for logging sale and retrieving payment.
 */
public class POS {
    private int balance;
    CashPayment payment;
    ArrayList<Sale> sales;

    /**
     * Creates a new instance. Sets the balance and creates a list for the logged sales.
     * @param currentBalance The amount of balance in the POS system.
     */
    public POS(int currentBalance){
        balance = currentBalance;
        sales = new ArrayList<Sale>();
    }

    /**
     * Adds payment to the POS system.
     * @param payment The payment.
     */
    public void addPayment(CashPayment payment){
        this.payment = payment;
    }

    /**
     * Updates the balance in accordance with the payment.
     */
    public void updateBalance(){
        balance += (payment.getTotal() - payment.getChange());
    }

    /**
     * Logs the ended sale.
     * @param sale The ended sale.
     */
    public void LogSale(Sale sale){
        sales.add(sale);
    }

    /**
     * @return Balance in the POS system. 
     */
    public int getBalance(){
        return balance;
    }
}
