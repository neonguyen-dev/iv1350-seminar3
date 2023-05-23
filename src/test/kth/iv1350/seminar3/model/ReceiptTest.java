package test.kth.iv1350.seminar3.model;

import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Test;

import se.kth.iv1350.seminar3.integration.ItemDTO;
import se.kth.iv1350.seminar3.integration.VatRate;
import se.kth.iv1350.seminar3.model.CashPayment;
import se.kth.iv1350.seminar3.model.Receipt;
import se.kth.iv1350.seminar3.model.Sale;

public class ReceiptTest {
    @Test
    public void testReceiptTotString() {
        int serialNumber = 0;
        String itemName = "Köttbullar";
        float price = 25.0f;
        VatRate vatRate = VatRate.twentyFive;
        int saleQuantity = 2;

        ItemDTO item = new ItemDTO(serialNumber, itemName, price, vatRate, 100);
        Sale sale = new Sale();
        sale.updateSaleInfo(item, saleQuantity);

        int paidAmount = 100;

        CashPayment payment = new CashPayment(paidAmount);
        payment.calculatePayment(sale.getAmount());
        
        Receipt receipt = new Receipt(sale, payment);
        LocalTime saleTime = LocalTime.now();
        String expectedResult = "POS\n\n" +
                                "Sale Time: " + saleTime.getHour() + ":" + saleTime.getMinute() + "\n\n" + 
                                "Purchased Items:\n" + Integer.toString(saleQuantity) + " " + 
                                itemName + " " + 
                                Float.toString(price) + " per piece\n" +
                                "\n\nTotal Amount: " + Float.toString(price * saleQuantity) + 
                                "\nVat Amount: " + Float.toString((price * 0.25f) * saleQuantity) + 
                                "\nRunning total: " + Float.toString((price * saleQuantity) + (price * 0.25f) * saleQuantity) + 
                                "\n\nTo pay in cash: " + Integer.toString(Math.round(((price * saleQuantity) + (price * 0.25f) * saleQuantity) + 0.5f)) + 
                                "\nPaid amount: " + Integer.toString(paidAmount) + 
                                "\nChange: " + Float.toString(paidAmount - Math.round(((price * saleQuantity) + (price * 0.25f) * saleQuantity) + 0.5f));


        String result = receipt.receiptTotString();
        assertTrue("Wrong prinout",result.contains(expectedResult));
        assertTrue("Wrong hour" ,result.contains(Integer.toString(saleTime.getHour())));
        assertTrue("Wrong minute",result.contains(Integer.toString(saleTime.getMinute())));
    }
}
