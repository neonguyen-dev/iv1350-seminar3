package se.kth.iv1350.seminar3.integration;

/**
 * Responsible for creating the external systems
 */
public class ExternalSystemCreator {
    private InventorySystem inventoryDbHandler;
    private AccountingSystem accountingDbHandler;

    /**
     * Creates a new instance and creates the external systems.
     * @param balance Amount that is in the accounting system.
     */
    public ExternalSystemCreator(float balance){
        inventoryDbHandler =  new InventorySystem();
        accountingDbHandler = new AccountingSystem(balance);
    }

    /**
     * @return The external inventory system
     */
    public InventorySystem getInventorySystem(){
        return inventoryDbHandler;
    }

    /**
     * @return The external accounting system
     */
    public AccountingSystem getAccountingSystem(){
        return accountingDbHandler;
    }
}
