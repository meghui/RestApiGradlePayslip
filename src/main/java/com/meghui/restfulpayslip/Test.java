package com.meghui.restfulpayslip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Meggie Xuan Hui
 * @since 3/8/21
 */
public class Test {

        public static void main(String[] args) throws Exception {

        String tagA = "Java Application:";
        String tagB = "<End>";
        String message;
        
        List<List<String>> csvLineList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/huixuan/OneDrive - University of Tasmania/portfolio/payslip4seisma/src/main/java/com/example/csvDemo.csv"));

        String csv;
        while((csv = bufferedReader.readLine()) != null){
            String[] csvLine = csv.split(",");
            csvLineList.add(Arrays.asList(csvLine));
        }
        for(List<String> csvLine: csvLineList) {
            System.out.println(csvLine.toString());

            String c = csvLine.toString().trim().substring(1).trim();
            c = c.trim().substring(0, c.length()-1).trim();
            //process the input data
            //Check if input from index.jsp is empty, then exit
            if (c.isEmpty()) {
                message = tagA + "No input." + tagB;
            }else if (c.split(",").length < 5) {
                message = "Invalid csv record. Valid csv record has 5 items separated by comma";
            } else if (c.split(",").length > 5){
                message = "Fields are over 5. Please make sure you input 5 fields only";
            } else {
                Validator v = new Validator();
                message = v.checkMissing(c);
                if (message.equals("")) {
                    Generator gnrt = new Generator();
                    CSV csvEntity = gnrt.generateCSV(c);
                    message = v.checkIllegals(csvEntity);
                    if (message.equals("")) {
                        CSV csvFormatted = gnrt.generateCSVFormatted(csvEntity);
                        Employee employee = gnrt.generateEmployee(csvFormatted);
                        PaySlip payslip = gnrt.generatePaySlip(employee);
                        message = payslip.toString() + " (name, pay period, gross income, income tax, net income, super) ";
                    }
                }
            }
            System.out.println(message);
        }
    }
}