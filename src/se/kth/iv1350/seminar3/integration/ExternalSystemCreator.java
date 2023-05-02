package se.kth.iv1350.seminar3.integration;

public class ExternalSystemCreator {
    private DiscountSystem discountDbHandler;
    private InventorySystem inventoryDbHandler;
    private AccountingSystem accountingDbHandler;

    public ExternalSystemCreator(){
        discountDbHandler = new DiscountSystem();
        inventoryDbHandler =  new InventorySystem();
        accountingDbHandler = new AccountingSystem();
    }
    public DiscountSystem getDiscountSystem(){
        return discountDbHandler;
    }
    public InventorySystem getInventorySystem(){
        return inventoryDbHandler;
    }
    public AccountingSystem getAccountingSystem(){
        return accountingDbHandler;
    }
}
