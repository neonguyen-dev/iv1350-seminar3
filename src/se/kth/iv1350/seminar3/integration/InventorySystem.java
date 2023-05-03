package se.kth.iv1350.seminar3.integration;

import java.util.ArrayList;

import se.kth.iv1350.seminar3.ItemDTO;
import se.kth.iv1350.seminar3.VatRate;
import se.kth.iv1350.seminar3.model.Sale;

/**
 * Enumerator list of items with its given item description.
 */
enum Items {
    ligma(0, "ligma", 0.0f, VatRate.twentyFive),
    milk(1, "milk", 15.0f, VatRate.twentyFive),
    egg(2, "egg", 50.0f, VatRate.twentyFive),
    bread(3, "bread", 20.0f, VatRate.twentyFive);

    int serialNumber;
    String name;
    float price;
    VatRate vatRate;

    Items(int serialNumber, String name, float price, VatRate vatRate) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
    }
}

/**
 * The external inventory system that is responsible of receiving calls and returning information to the controller with 
 * regards to scanning items. 
 */
public class InventorySystem {
    ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

    /**
     * Creates an instance and calls on addItems().
     */
    public InventorySystem() {
        addItems();
    }

    /**
     * Fills the list with the information of the Enum.
     */
    private void addItems() {

        for (int i = 0; i < Items.values().length; i++) {
            items.add(new ItemDTO(Items.values()[i].serialNumber,
                    Items.values()[i].name,
                    Items.values()[i].price,
                    Items.values()[i].vatRate,
                    500));
        }
    }

    /**
     * Method for finding an item after it has been scanned.
     * @param serialNumber Used as an item identifier.
     * @return If the item is in inventory the specified item is returned with its given data. Else return null.
     */
    public ItemDTO findItem(int serialNumber) {
        for (int i = 0; i < Items.values().length; i++) {
            if (items.get(i).getSerialNumber() == serialNumber) {
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * Updates the inventory system in accordance with the logged and paid sale.
     * @param sale The sale that has been logged and paid for.
     */
    public void updateInventorySystem(Sale sale) {
        for (int i = 0; i < sale.getItems().size(); i++) {
            items.get(items.indexOf(sale.getItems().get((i)))).setQuantity(sale.getItems().get(i).getSaleQuantity());
        }
    }
}