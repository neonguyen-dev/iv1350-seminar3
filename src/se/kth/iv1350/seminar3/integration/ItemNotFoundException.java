package se.kth.iv1350.seminar3.integration;

/**
 * Exception for item not being found.
 */
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

    /**
     * @return Item identifier for an invalid item.
     */
    public int getInvalidItemIdentifier(){
        return serialNumber;
    }
}
