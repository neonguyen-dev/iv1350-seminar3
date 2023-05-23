package test.kth.iv1350.seminar3.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.kth.iv1350.seminar3.integration.ItemDTO;
import se.kth.iv1350.seminar3.integration.VatRate;
import se.kth.iv1350.seminar3.model.CashPayment;
import se.kth.iv1350.seminar3.model.Sale;

public class CashPaymentTest {
    @Test
    public void testCalculatePayment() {
        ItemDTO item = new ItemDTO(0, "Köttbullar", 25.0f, VatRate.twentyFive, 100);
        Sale sale = new Sale();
        sale.updateSaleInfo(item, 2);

        int paidAmount = 100;

        CashPayment payment = new CashPayment(paidAmount);
        payment.calculatePayment(sale.getAmount());

        String expectedResult = Integer.toString(Math.round(sale.getAmount().getRunningTotal() + 0.5f));
        String result = Integer.toString(payment.getTotal());

        assertTrue("Payment is incorrect",result.contains(expectedResult));
    }

    @Test
    public void testGetChange() {
        ItemDTO item = new ItemDTO(0, "Köttbullar", 25.0f, VatRate.twentyFive, 100);
        Sale sale = new Sale();
        sale.updateSaleInfo(item, 2);

        int paidAmount = 100;

        CashPayment payment = new CashPayment(paidAmount);
        payment.calculatePayment(sale.getAmount());

        String expectedResult = Integer.toString(paidAmount - payment.getTotal());
        String result = Float.toString(payment.getChange());

        assertTrue("Change is incorrect",result.contains(expectedResult));
    }
}
