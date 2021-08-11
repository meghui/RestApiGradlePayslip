package com.meghui.restfulpayslip;

/**
 * @author Meggie Xuan Hui
 * @since 11/8/21
 */
public class TaxRate {

    private int min_income;
    private int max_income;
    private float rate;
    private int plus;

    public int getMin_income() {
        return min_income;
    }

    public void setMin_income(int min_income) {
        this.min_income = min_income;
    }

    public int getMax_income() {
        return max_income;
    }

    public void setMax_income(int max_income) {
        this.max_income = max_income;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }
}
