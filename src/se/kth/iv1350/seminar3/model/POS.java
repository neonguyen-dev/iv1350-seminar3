package se.kth.iv1350.seminar3.model;

import java.util.ArrayList;

import se.kth.iv1350.seminar3.Amount;

public class POS {
    private int balance;
    ArrayList<Sale> sales;

    public POS(int currentBalance){
        balance = currentBalance;
        sales = new ArrayList<Sale>();
    }
    public void addPayment(CashPayment payment){

    }
    public void updateBalance(Amount amountPaid){
        balance += amountPaid.getTotalAmount();
    }
    public void LogSale(Sale sale){

    }
}
