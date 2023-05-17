package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.model.*;
import se.kth.iv1350.seminar3.Amount;
import se.kth.iv1350.seminar3.FileLogger;
import se.kth.iv1350.seminar3.ItemDTO;

/**
 * Represents the Controller of the MVC-layer.
 */
public class Controller {
    Printer printer;
    ExternalSystemCreator creator;
    InventorySystem inventoryDbHandler;
    AccountingSystem accountingDbHandler;
    POS posSystem;
    Sale sale;
    CashPayment payment;
    private FileLogger fileLogger;

    /**
     * Creates a new instance. The controller is being initiated and assigns the dbHandlers, posSystem and printer.
     * @param printer Represents printer that is inititated through main
     * @param creator The external system creator that is used to connect to the data bases
     * @param balance The balance in the POS system
     */
    public Controller(Printer printer, ExternalSystemCreator creator, int balance){
        inventoryDbHandler = creator.getInventorySystem();
        accountingDbHandler = creator.getAccountingSystem();
        posSystem = new POS(balance);
        this.printer = printer;
        fileLogger = new FileLogger();
    }

    /**
     * Inititates a new sale
     */
    public void startSale(){
        sale = new Sale();
    }

    /**
     * Scans an item.
     * @param itemSerial Used as an item identifier to match it with something in the inventory system
     * @param quantity The amount of pieces of that item
     * @return Item with matching item identifier
     * @throws ItemNotFoundException Exception for invalid item identifier
     */
    public ItemDTO scanItem(int itemSerial, int quantity) throws ItemNotFoundException, DatabaseCouldNotBeFoundException{
        try {
            ItemDTO mathchingItem = inventoryDbHandler.findItem(itemSerial);
            sale.updateSaleInfo(mathchingItem, quantity);
            return mathchingItem;
        } catch (ItemNotFoundException e) {
            fileLogger.log(e.getMessage());
            throw new ItemNotFoundException(itemSerial);
        }
    }

    /**
     * Ends the sale
     * @return The total amount of the sale
     */
    public Amount endSale(){
        return sale.getAmount();
    }

    /**
     * The customer hands over the cash and is currently paying.
     * @param paidAmount The amount that the customer is handing over.
     */
    public void pay(int paidAmount){
        payment = new CashPayment(paidAmount);
        payment.calculatePayment(sale.getAmount());
        posSystem.addPayment(payment);
        posSystem.LogSale(sale);
        posSystem.updateBalance();
        inventoryDbHandler.updateInventorySystem(sale);
        accountingDbHandler.updateAccountingSystem(sale);
        printer.PrintReceipt(new Receipt(sale, payment));
    }
}