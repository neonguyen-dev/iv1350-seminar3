package se.kth.iv1350.seminar3.model;

import java.time.LocalTime;

/**
 * The receipt that confirms the sale.
 */
public class Receipt {
    Sale sale;
    CashPayment payment;

    /**
     * Creates a new instance, in accordance with the sale that is going to be confirmed and payment.
     * @param sale The sale that is going to be confirmed.
     * @param payment The payment of the customer.
     */
    public Receipt(Sale sale, CashPayment payment){
        this.sale = sale;
        this.payment = payment;
    }

    /**
     * Method responsible of translating the sale to String.
     * @return The receipt in String.
     */
    public String receiptTotString(){
        StringBuilder builder = new StringBuilder();
        LocalTime saleTime = LocalTime.now();

        builder.append("POS\n\n");

        builder.append("Sale Time: ");
        builder.append(saleTime.getHour() + ":" + saleTime.getMinute() + "\n\n");

        builder.append("Purchased Items:\n");

        for (int i = 0; i < sale.getItems().size(); i++) {
            builder.append(sale.getItems().get(i).getSaleQuantity() +  " " +
                           sale.getItems().get(i).getName() + " " + 
                           sale.getItems().get(i).getPrice() +  " per piece\n");
        }
        builder.append("\n\nTotal Amount: " + sale.getAmount().getTotalAmount());
        builder.append("\nVat Amount: " + sale.getAmount().getVatAmount());
        builder.append("\nRunning total: " + sale.getAmount().getRunningTotal());
        
        builder.append("\n\nTo pay in cash: " + payment.getTotal());
        builder.append("\nPaid amount: " + payment.getPaidAmount());
        builder.append("\nChange: " + payment.getChange());

        return builder.toString();
    }
}
