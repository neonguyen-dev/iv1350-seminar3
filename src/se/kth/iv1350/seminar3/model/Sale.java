package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.Amount;
import se.kth.iv1350.seminar3.ItemDTO;
import java.util.ArrayList;

/**
 * Represents the whole sale.
 */
public class Sale {
    Amount amount;
    ArrayList<ItemDTO> items;

    /**
     * Creates a new instance of Sale and assigns the amount to pay to 0.
     */
    public Sale() {
        amount = new Amount(0, 0);
        items = new ArrayList<ItemDTO>();
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
    public Amount getAmount(){
        return amount;
    }

    /**
     * @return List of the items that has been matched
     */
    public ArrayList<ItemDTO> getItems(){
        return items;
    }
}
