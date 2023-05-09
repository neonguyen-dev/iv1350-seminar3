package se.kth.iv1350.seminar3;

/**
 * Collection of data of an item.
 */
public class ItemDTO {
    int serialNumber;
    String name;
    float price;
    VatRate vatRate;
    int quantity;
    int saleQuantity;

    /**
     * Creates a new instance of ItemDTO.
     * @param serialNumber Used as an item identifier.
     * @param name Name of the item.
     * @param price Price of the item.
     * @param vatRate The VAT rate of the item.
     * @param quantity Quantity in the inventory system.
     */
    public ItemDTO(int serialNumber, String name, float price, VatRate vatRate, int quantity){
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
        this.quantity = quantity;
        saleQuantity = 0;
    }
    
    /**
     * @return Item identifier.
     */
    public int getSerialNumber(){
        return serialNumber;
    }    

    /**
     * @return Name of item.
     */
    public String getName(){
        return name;
    }

    /**
     * @return Price of item.
     */
    public float getPrice(){
        return price;
    }

    /**
     * @return VAT rate of item.
     */
    public float getVatRate(){
        return vatRate.rate;
    }

    /**
     * @return The quantity in given sale.
     */
    public int getSaleQuantity(){
        return saleQuantity;
    }

    public float getRunningTotal(){
        return price * (1 + vatRate.rate);
    }

    /**
     * Increments the quantity in given sale
     */
    public void increaseSaleQuantity(){
        saleQuantity++;
    }
    
    /**
     * Decreases the quantity in inventory with the quantity in finished sale.
     * @param saleQuantity The quantity in finished sale
     */
    public void setQuantity(int saleQuantity){
        quantity -= saleQuantity;
    }

    /**
     * Resets the sale quantity after sale
     */
    public void resetSaleQuantity() {
        saleQuantity = 0;
    }
}