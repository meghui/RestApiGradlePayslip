package com.meghui.restfulpayslip.utils;

import com.meghui.restfulpayslip.entities.Employee;
import com.meghui.restfulpayslip.entities.PaySlip;

/**
 * @author Meggie Xuan Hui
 * @since 3/8/21
 * The order of inputs is
 * first name,
 * last name,
 * annual salary,
 * super rate (%),
 * payment start date.
 *
 * The order of outputs on payslip is
 * Full Name
 * Period
 * Gross Income
 * Income Tax
 * Net Income
 * Super
 */
public class Generator {

    public PaySlip generatePaySlip (Employee employee) throws Exception {

        PaySlip payslip = new PaySlip();

        Calculator calculator = new Calculator();

        payslip.setEmployee(employee);
        payslip.setPayPeriod(employee.getStartDateOfPayment() + " - " + calculator.calEndDate(employee.getStartDateOfPayment()));
        payslip.setGrossIncome(calculator.calGrossIncome(employee.getAnnualSalary()));
        payslip.setIncomeTax(calculator.calIncomeTax(employee.getAnnualSalary()));
        payslip.setNetIncome(calculator.calNetIncome(employee.getAnnualSalary()));
        payslip.setSuperValue(calculator.calSuper(employee.getAnnualSalary(), employee.getSuperRate()));

        return payslip;

    }


    //formatStartDate() capital first letter and change to same length
    public String formatStartDate(String startDate) {
        String[] parts = startDate.split(" ",2);
        String day = parts[0].trim();
        String month = parts[1].trim().toLowerCase();
        //change to same format of month as end date
        if(month.equals("jan")){
            month = "january";
        }
        if(month.equals("feb")){
            month = "february";
        }
        if(month.equals("mar")){
            month = "march";
        }
        if(month.equals("apr")){
            month = "april";
        }
        if(month.equals("jun")){
            month = "june";
        }
        if(month.equals("jul")){
            month = "july";
        }
        if(month.equals("aug")){
            month = "august";
        }
        if(month.equals("sep")){
            month = "september";
        }
        if(month.equals("oct")){
            month = "october";
        }
        if(month.equals("nov")){
            month = "november";
        }
        if(month.equals("dec")){
            month = "december";
        }
        //capitalise the first letter
        month = month.substring(0,1).toUpperCase() + month.substring(1);
        startDate = day + " " + month;
        //setStartDate() adds function of adding "0" before the day if day is 1 ~ 9;1 March -> 01 March
        if (day.length() == 1) {
            startDate = "0" + startDate;
        }
        return startDate;
    }

}
