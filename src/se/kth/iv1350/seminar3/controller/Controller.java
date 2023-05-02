package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.model.*;
import se.kth.iv1350.seminar3.ItemDTO;

public class Controller {
    Printer printer;
    ExternalSystemCreator creator;
    InventorySystem inventoryDbHandler;
    DiscountSystem discountDbHandler;
    AccountingSystem accountingDbHandler;
    POS posSystem;
    Sale sale;

    public Controller(Printer printer, ExternalSystemCreator creator){
        inventoryDbHandler = creator.getInventorySystem();
        discountDbHandler = creator.getDiscountSystem();
        accountingDbHandler = creator.getAccountingSystem();
        //posSystem = new POS();
    }

    public void startSale(){
        sale = new Sale(inventoryDbHandler);
    }

    public void scanItem(int itemSerial, int quantity){
        ItemDTO mathchingItem = inventoryDbHandler.findItem(itemSerial);
        if(mathchingItem != null){
            sale.updateSaleInfo(mathchingItem, quantity);
        }
        else
            System.out.println("Item not found");
    }

    public void pay(int paidAmount){

    }

    public void discountRequest(){

    }
}