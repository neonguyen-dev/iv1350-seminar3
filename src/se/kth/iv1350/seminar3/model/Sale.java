package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.Amount;
import se.kth.iv1350.seminar3.ItemDTO;
import se.kth.iv1350.seminar3.integration.*;
import java.time.*;
import java.util.ArrayList;

public class Sale {
    LocalTime dateOfSale;
    Amount amount;
    ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();
    InventorySystem inventorySystem;

    public Sale(InventorySystem inventorySystem) {
        this.inventorySystem = inventorySystem;
        amount = new Amount(0, 0);
    }

    public void updateSaleInfo(ItemDTO matchingItem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            amount.setTotalAmount(matchingItem.getPrice());
            amount.setVatAmount(matchingItem.getPrice() * matchingItem.getVatRate());

            if (items.contains(matchingItem))
                items.get(items.indexOf(matchingItem)).increaseQuantity();
            else
                items.add(matchingItem);
        }
        amount.setRunningTotal();
    }
}
