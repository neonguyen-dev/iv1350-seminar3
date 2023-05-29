package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.controller.*;
import se.kth.iv1350.seminar3.integration.DatabaseCouldNotBeFoundException;
import se.kth.iv1350.seminar3.integration.ItemDTO;
import se.kth.iv1350.seminar3.integration.ItemNotFoundException;

/**
 * Following program has no view. Class is used as a placeholder.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance
     * 
     * @param contr The controller that is used for all operations
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addObserver(new TotalRevenueView());
    }

    /**
     * Tests a sample of the program
     */
    public void test() {
        int[] serialNumbers = { 0, 1, 2, 3, 4, 5, 6 };
        contr.startSale();
        for (int i = 0; i < serialNumbers.length; i++) {
            try {
                ItemDTO tempItem = contr.scanItem(serialNumbers[i], 1);
                System.out.println("Item: " + tempItem.getName());
                System.out.println("Price: " + tempItem.getPrice());
                System.out.println("Running total: " + tempItem.getRunningTotal() + "\n");
            } catch (ItemNotFoundException e) {
                System.out.println("Item with serial number "  + e.getInvalidItemIdentifier() + " was not found");
            }
            catch(DatabaseCouldNotBeFoundException e){
                System.out.println("Database could not be reached");
            }
        }
        contr.endSale();
        contr.pay(200);

        contr.startSale();
        for (int i = 0; i < serialNumbers.length; i++) {
            try {
                ItemDTO tempItem = contr.scanItem(serialNumbers[i], 1);
                System.out.println("Item: " + tempItem.getName());
                System.out.println("Price: " + tempItem.getPrice());
                System.out.println("Running total: " + tempItem.getRunningTotal() + "\n");
            } catch (ItemNotFoundException e) {
                System.out.println("Item with serial number "  + e.getInvalidItemIdentifier() + " was not found");
            }
            catch(DatabaseCouldNotBeFoundException e){
                System.out.println("Database could not be reached");
            }
        }
        contr.endSale();
        contr.pay(200);

    }
}