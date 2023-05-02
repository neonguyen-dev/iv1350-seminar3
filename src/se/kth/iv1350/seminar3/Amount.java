package se.kth.iv1350.seminar3;

public class Amount {
    float totalAmount;
    float vatAmount;
    float runningTotal;

    public Amount(float totalAmount, float vatAmount){
        this.totalAmount = totalAmount;
        this.vatAmount = vatAmount;
        runningTotal += totalAmount + vatAmount;
    }
    public float getTotalAmount(){
        return totalAmount;
    }
    public void setTotalAmount(float amount){
        totalAmount += amount;
    }

    public float getVatAmount(){
        return vatAmount;
    }
    public void setVatAmount(float amount){
        vatAmount += amount;
    }
    
    public float getRunningTotal(){
        return runningTotal;
    }
    public void setRunningTotal(){
        runningTotal = totalAmount + vatAmount;
    }
}
