package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.controller.*;

/**
 * Following program has no view. Class is used as a placeholder.
 */
public class View{
    private Controller contr;

    /**
     * Creates a new instance
     * @param contr The controller that is used for all operations
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /**
     * Tests a sample of the program
     */
    public void test(){
        contr.startSale();
        contr.scanItem(3, 2);
        contr.scanItem(2, 1);
        contr.scanItem(3, 1);
        contr.endSale();
        contr.pay(200);
    }
}