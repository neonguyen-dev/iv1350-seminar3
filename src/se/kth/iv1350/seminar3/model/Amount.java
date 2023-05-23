package se.kth.iv1350.seminar3;

/**
 * A body that specifies amount to pay in a given sale.
 */
public class Amount {
    float totalAmount;
    float vatAmount;
    float runningTotal;

    /**
     * Creates a new instance. 
     * @param totalAmount The total amount for the sale excluding VAT.
     * @param vatAmount The amount in VAT.
     */
    public Amount(float totalAmount, float vatAmount){
        this.totalAmount = totalAmount;
        this.vatAmount = vatAmount;
    }

    /**
     * @return Total amount for the whole sale excluding VAT.
     */
    public float getTotalAmount(){
        return totalAmount;
    }

    /**
     * Adds the amount to the total amount.
     * @param amount The amount to add.
     */
    public void setTotalAmount(float amount){
        totalAmount += amount;
    }

    /**
     * @return The amount in VAT.
     */
    public float getVatAmount(){
        return vatAmount;
    }

    /**
     * Adds amount in VAT to the VAT amount
     * @param amount The amount in VAT to add
     */
    public void setVatAmount(float amount){
        vatAmount += amount;
    }
    
    /**
     * @return The running total, including total amount and VAT amount.
     */
    public float getRunningTotal(){
        return runningTotal;
    }

    /**
     * Runningtotal is total amount + VAT amount.
     */
    public void setRunningTotal(){
        runningTotal = totalAmount + vatAmount;
    }
}
