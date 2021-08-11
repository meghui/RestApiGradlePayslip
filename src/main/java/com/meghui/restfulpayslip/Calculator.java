package com.meghui.restfulpayslip;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Meggie Xuan Hui
 * @since 3/8/21
 */
public class Calculator {

    public int calGrossIncome (int annualSalary) {
        return Math.round(((float)annualSalary) / 12);
    }

    public int calIncomeTax (int annualSalary) throws Exception {
        //read .json file to String
        InputStream inputStream = getClass().getResourceAsStream("/taxrates.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String jsonArray = reader.lines().collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<TaxRate> rates = mapper.readValue(jsonArray, new TypeReference<>() {});

        int incomeTax = -1;
            if (annualSalary <= rates.get(0).getMax_income()) { //TODO replace number to variable in case of change
                incomeTax = 0;
            }

            if (annualSalary <= rates.get(1).getMax_income() && annualSalary > rates.get(1).getMin_income()) {
                incomeTax = Math.round(rates.get(1).getRate() * ((float)annualSalary - rates.get(1).getMin_income() + 1)/12);
            }

            if (annualSalary <= rates.get(2).getMax_income() && annualSalary > rates.get(2).getMin_income()) {
                incomeTax = Math.round((rates.get(2).getPlus() + rates.get(2).getRate() * ((float)annualSalary - rates.get(2).getMin_income()) + 1) /12);
            }

            if (annualSalary <= rates.get(3).getMax_income() && annualSalary > rates.get(3).getMin_income()) {
                incomeTax = Math.round((rates.get(3).getPlus() + rates.get(3).getRate() * ((float)annualSalary - rates.get(3).getMin_income()) + 1) /12);
            }

            if (annualSalary  > rates.get(4).getMin_income()) {
                incomeTax = Math.round((rates.get(4).getPlus() + rates.get(4).getRate() * ((float)annualSalary - rates.get(4).getMin_income()) + 1) /12);
            }
            return incomeTax;
    }

    public int calSuper (int annualSalary, float rate) {
        return Math.round(calGrossIncome(annualSalary) * rate);
    }

    public int calNetIncome (int annualSalary) throws Exception {
        return calGrossIncome(annualSalary) - calIncomeTax(annualSalary);
    }

    //calEndDate() calculates the end date of the month based on the startDate
    //calEndDate() is the most time-consuming among all the methods in com.example.Employee.java
    public String calEndDate (String startDate)  {//1 March
        //substring() remove day and space
        String month = String.valueOf(mapMonthLettersToNum(startDate.substring(startDate.indexOf(" ")+1)));
        startDate = startDate.substring(0,startDate.indexOf(" ")) + " " + month + " 2021"; //1 3 -> 1 3 2021
        LocalDate convertedSD = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("d M yyyy")); //String "1 3 2021" to LocalDate;LocalDate.parse() parses String date to LocalDate

        LocalDate lastDateOfMonth = LocalDate.of(convertedSD.getYear(), convertedSD.getMonth(), convertedSD.getMonth().length(convertedSD.isLeapYear())); //2021-03-31;LocalDate.withDayOfMonth() gets the length of the month; LocalDate.getMonth() gets the month of given date; LocalDate.isLeapYear() adds one day for Feb if leap year;
        String monthEnd = lastDateOfMonth.toString();//2021-03-31
        //DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(lastDateOfMonth);//In IntelliJ:31 Mar 2021; In Google Cloud Minikube, Mar 31, 2021

        String st = monthEnd.substring(monthEnd.indexOf("-")+1);//2021-03-31 -> 03-31
        String day = st.substring(st.indexOf("-")+1);
        month = st.substring(0, st.indexOf("-")); //03-31 -> 03
        month = mapMonthNumToLetters(month);// 03 -> March
        return day + " "+ month; // 31 March
    }


    //mapMonthLetterToNum maps the month to its number presenting
    public String mapMonthLettersToNum (String monthLetters) {
        String monthNum = "-1";
        switch (monthLetters.toLowerCase()) {
            case "january":
            case "jan":
                monthNum = "1";
                break;
            case "february":
            case "feb":
                monthNum = "2";
                break;
            case "march":
            case "mar":
                monthNum = "3";
                break;
            case "april":
            case "apr":
                monthNum = "4";
                break;
            case "may":
                monthNum = "5";
                break;
            case "june":
            case "jun":
                monthNum = "6";
                break;
            case "july":
            case "jul":
                monthNum = "7";
                break;
            case "august":
            case "aug":
                monthNum = "8";
                break;
            case "september":
            case "sep":
                monthNum = "9";
                break;
            case "october":
            case "oct":
                monthNum = "10";
                break;
            case "november":
            case "nov":
                monthNum = "11";
                break;
            case "december":
            case "dec":
                monthNum = "12";
                break;
        }
        return monthNum;
    }
    public String mapMonthNumToLetters (String monthNum) {
        String monthLetters = null;
        if (monthNum.charAt(0) == '0') {
            monthNum = monthNum.substring(1);
        }
        switch (monthNum) {
            case "1":
                monthLetters = "January";
                break;
            case "2":
                monthLetters = "February";
                break;
            case "3":
                monthLetters = "March";
                break;
            case "4":
                monthLetters = "April";
                break;
            case "5":
                monthLetters = "May";
                break;
            case "6":
                monthLetters = "June";
                break;
            case "7":
                monthLetters = "July";
                break;
            case "8":
                monthLetters = "August";
                break;
            case "9":
                monthLetters = "September";
                break;
            case "10":
                monthLetters = "October";
                break;
            case "11":
                monthLetters = "November";
                break;
            case "12":
                monthLetters = "December";
                break;
        }
        return monthLetters;
    }

}
