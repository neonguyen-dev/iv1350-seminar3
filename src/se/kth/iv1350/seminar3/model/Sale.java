package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole sale.
 */
public class Sale {
    private Amount amount;
    private ArrayList<ItemDTO> items;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates a new instance of Sale and assigns the amount to pay to 0.
     */
    public Sale() {
        amount = new Amount(0, 0);
        items = new ArrayList<>();
    }

    /**
     * Updates the sale info and amount in accordance with the items that has been matched.
     * @param matchingItem The item that has been matched from the inventory system.
     * @param quantity The quantity of the matched item.
     */
    public void updateSaleInfo(ItemDTO matchingItem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            amount.setTotalAmount(matchingItem.getPrice());
            amount.setVatAmount(matchingItem.getPrice() * matchingItem.getVatRate());

            if (items.contains(matchingItem))
                items.get(items.indexOf(matchingItem)).increaseSaleQuantity();
            else{
                items.add(matchingItem);
                items.get(items.indexOf(matchingItem)).increaseSaleQuantity();
            }
        }
        amount.setRunningTotal();
    }

    /**
     * @return The amount of the whole sale
     */
    public Amount  getAmount(){
        return amount;
    }

    /**
     * @return List of the items that has been matched
     */
    public ArrayList<ItemDTO> getItems(){
        return items;
    }

    public void pay(POS posSystem, CashPayment payment){
        posSystem.addPayment(payment);
        posSystem.LogSale(this);
        posSystem.updateBalance();
        notifyObservers(payment);
    }

    /**
     * Adds a single sale observer.
     * @param saleObserver The sale observer to be added.
     */
    public void addSaleObserver(SaleObserver saleObserver){
        saleObservers.add(saleObserver);
    }
   
    /**
     * Adds a list of sale observers.
     * @param saleObservers List of sale observers.
     */
    public void addSaleObserver(List<SaleObserver> saleObservers){
        this.saleObservers.addAll(saleObservers);
    }

    /**
     * Notifies the sale observers and calls on newSale.
     * @param payment Payment of the sale.
     */
    private void notifyObservers(CashPayment payment){
        for (SaleObserver observer : saleObservers) {
            observer.newSale(payment.getTotal());
        }
    }
}
