package se.kth.iv1350.seminar3.integration;

import java.util.ArrayList;

import se.kth.iv1350.seminar3.ItemDTO;
import se.kth.iv1350.seminar3.VatRate;

enum Items{
    ligma(0, "ligma", 0.0f, VatRate.twentyFive),
    milk(1, "milk", 15.0f, VatRate.twentyFive),
    egg(2, "egg", 50.0f, VatRate.twentyFive),
    bread(3, "bread", 20.0f, VatRate.twentyFive);

    int serialNumber;
    String name;
    float price;
    VatRate vatRate;

    Items(int serialNumber, String name, float price, VatRate vatRate){
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
    } 
}

public class InventorySystem {
    ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();
    public InventorySystem(){
        addItems();
    }

    private void addItems(){
        for (int i = 0; i < Items.values().length; i++) {
            items.add(new ItemDTO(Items.values()[i].serialNumber, 
                                  Items.values()[i].name, 
                                  Items.values()[i].price, 
                                  Items.values()[i].vatRate));
        }    
    }

    public ItemDTO findItem(int serialNumber){
        for (int i = 0; i < Items.values().length; i++) {
            ItemDTO tempItem = items.get(i);
            if(tempItem.getSerialNumber() == serialNumber){
                return items.get(i);
            }
        }
        return null;
    }
}