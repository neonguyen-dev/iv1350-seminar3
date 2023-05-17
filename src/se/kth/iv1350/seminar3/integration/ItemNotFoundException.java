package se.kth.iv1350.seminar3.integration;

public class ItemNotFoundException extends Exception{
    private int serialNumber;

    /**
     * Creates a new instance.
     * @param serialNumber Item identifier
     */
    public ItemNotFoundException(int serialNumber){
        super("Item with identifier \"" + serialNumber + "\" could not be found in InventorySystem");
        this.serialNumber = serialNumber;
    }

    public int getInvalidItemIdentifier(){
        return serialNumber;
    }
}
