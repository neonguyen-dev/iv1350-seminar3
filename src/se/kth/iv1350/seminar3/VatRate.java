package se.kth.iv1350.seminar3;

public enum VatRate {
    twentyFive(0.25f),
    twelve(0.12f),
    six(0.06f);

    float rate;

    VatRate(float rate){
        this.rate = rate;
    }
}
