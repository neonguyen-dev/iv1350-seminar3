package se.kth.iv1350.seminar3;

/**
 * Enumerator for the constant VAT rates of 6, 12 and 25 percent.
 */
public enum VatRate {
    twentyFive(0.25f),
    twelve(0.12f),
    six(0.06f);

    float rate;

    /**
     * Creates a new instance
     * @param rate The VAT rate
     */
    VatRate(float rate){
        this.rate = rate;
    }
}
