package com.meghui.restfulpayslip;

/**
 * @author Meggie Xuan Hui
 * @since 3/8/21
 *
 * The order of outputs on payslip is
 * Full Name
 * Period
 * Gross Income
 * Income Tax
 * Net Income
 * Super
 */
public class PaySlip {

    private Employee employee;

    private String payPeriod = null;
    private int incomeTax = -1; // Differentiate from first tier (<18200), in case getAnnualSalary is negative integer
    private int grossIncome = -1;
    private int netIncome = -1;
    private int superValue = -1;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(int grossIncome) {
        this.grossIncome = grossIncome;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public int getSuperValue() {
        return superValue;
    }

    public void setSuperValue(int superValue) {
        this.superValue = superValue;
    }

    //toString() formats the output
    public String toString() {
        return getEmployee()
                +getPayPeriod() + ","
                + getGrossIncome() + ","
                + getIncomeTax() + ","
                + getNetIncome() + ","
                + getSuperValue() ;
    }
}
