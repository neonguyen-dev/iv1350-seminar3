package se.kth.iv1350.seminar3;

public class ItemDTO {
    int serialNumber;
    String name;
    float price;
    VatRate vatRate;
    int quantity;

    public ItemDTO(int serialNumber, String name, float price, VatRate vatRate){
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        quantity = 1;
    }
    public int getSerialNumber(){
        return serialNumber;
    }    
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public float getVatRate(){
        return vatRate.rate;
    }
    public int getQuantity(){
        return quantity;
    }
    public void increaseQuantity(){
        quantity++;
    }
    
}
