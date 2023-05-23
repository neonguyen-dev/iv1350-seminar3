package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.logger.FileLogger;
import se.kth.iv1350.seminar3.logger.TotalRevenueFileOutput;
import se.kth.iv1350.seminar3.model.*;
import se.kth.iv1350.seminar3.view.TotalRevenueView;

/**
 * Represents the Controller of the MVC-layer.
 */
public class Controller {
    private Printer printer;
    private InventorySystem inventoryDbHandler;
    private AccountingSystem accountingDbHandler;
    private POS posSystem;
    private Sale sale;
    private CashPayment payment;
    private FileLogger fileLogger;
    private TotalRevenueView totalRevenueView;
    private TotalRevenueFileOutput totalRevenueFileOutput;

    /**
     * Creates a new instance. The controller is being initiated and assigns the
     * dbHandlers, posSystem and printer.
     * 
     * @param printer Represents printer that is inititated through main
     * @param creator The external system creator that is used to connect to the
     *                data bases
     * @param balance The balance in the POS system
     */
    public Controller(Printer printer, ExternalSystemCreator creator, int balance) {
        inventoryDbHandler = creator.getInventorySystem();
        accountingDbHandler = creator.getAccountingSystem();
        posSystem = new POS(balance);
        this.printer = printer;
        fileLogger = new FileLogger();
        totalRevenueView = new TotalRevenueView();
        totalRevenueFileOutput = new TotalRevenueFileOutput();
    }

    /**
     * Inititates a new sale
     */
    public void startSale() {
        sale = new Sale();
        sale.addSaleObserver(totalRevenueView);
        sale.addSaleObserver(totalRevenueFileOutput);
    }

    /**
     * Scans an item.
     * 
     * @param itemSerial Used as an item identifier to match it with something in
     *                   the inventory system
     * @param quantity   The amount of pieces of that item
     * @return Item with matching item identifier
     * @throws ItemNotFoundException            Exception in case of invalid item
     *                                          identifier
     * @throws DatabaseCouldNotBeFoundException Exception in case of database not
     *                                          being found
     */
    public ItemDTO scanItem(int itemSerial, int quantity)
            throws ItemNotFoundException, DatabaseCouldNotBeFoundException {
        try {
            ItemDTO mathchingItem = inventoryDbHandler.findItem(itemSerial);
            sale.updateSaleInfo(mathchingItem, quantity);
            return mathchingItem;
        } catch (ItemNotFoundException e) {
            fileLogger.log(e.getMessage());
            throw e;
        } catch (DatabaseCouldNotBeFoundException e) {
            fileLogger.log(e.getMessage());
            throw e;
        }
    }

    /**
     * Ends the sale
     * 
     * @return The total amount of the sale
     */
    public Amount endSale() {
        return sale.getAmount();
    }

    /**
     * The customer hands over the cash and is currently paying.
     * 
     * @param paidAmount The amount that the customer is handing over.
     */
    public void pay(int paidAmount) {
        payment = new CashPayment(paidAmount);
        payment.calculatePayment(sale.getAmount());
        sale.pay(posSystem, payment);
        inventoryDbHandler.updateInventorySystem(sale);
        accountingDbHandler.updateAccountingSystem(sale);
        printer.PrintReceipt(new Receipt(sale, payment));

        for (ItemDTO items : sale.getItems()) {
            items.resetSaleQuantity();
        }
    }
}