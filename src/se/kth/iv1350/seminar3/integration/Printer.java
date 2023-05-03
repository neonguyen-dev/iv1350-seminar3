package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.model.Receipt;

/**
 * The printer that is responsible for the receipt being printed
 */
public class Printer {
    /**
     * Prints the receipt
     * @param receipt The receipt that is being printed
     */
    public void PrintReceipt(Receipt receipt){
        System.out.println(receipt.receiptTotString());
    }
}
