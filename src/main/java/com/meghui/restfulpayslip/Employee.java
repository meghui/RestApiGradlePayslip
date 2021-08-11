package com.meghui.restfulpayslip;


/**
 * @author Meggie Xuan Hui
 * @since 30/7/21
 * The order of inputs is
 * first name,
 * last name,
 * annual salary,
 * super rate (%),
 * payment start date.
 *
 */

public class Employee {

    private String firstName = null;
    private String lastName = null;
    private int annualSalary;
    private float superRate;

    private String startDateOfPayment; //TODO find a more efficient way to store date --I am trying additional csv.java


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
            this.annualSalary = annualSalary;
    }

    public float getSuperRate() {
        return this.superRate;
    }

    public void setSuperRate(float superRate) {
        this.superRate = superRate;
    }

    public String getStartDateOfPayment() {
        return startDateOfPayment;
    }

    public void setStartDateOfPayment(String startDateOfPayment) {
        this.startDateOfPayment = startDateOfPayment;
    }
}
