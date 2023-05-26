package se.kth.iv1350.seminar3.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.seminar3.model.SaleObserver;

/**
 * Observer used to log total revenue to a file.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private PrintWriter logWriter;
    private int totalSale;

    /**
     * Creates a new instance.
     */
    public TotalRevenueFileOutput() {
        totalSale = 0;
        try {
            logWriter = new PrintWriter(new FileWriter("revenue.txt"), true);
        } catch (IOException e) {
            System.out.println("Can't log");
            e.printStackTrace();
        }
    }

    /**
     * Logs a message in log.txt file
     * 
     * @param message The message
     */
    public void log(String message) {
        logWriter.println(message);
    }

    /**
     * Adds total sale value and logs total value of the whole sale in a .txt file
     * 
     * @param payment The payment of the sale
     */
    public void newSale(int total) {
        totalSale += total;
        log("Total cost since program started: " + totalSale);
    }
}
