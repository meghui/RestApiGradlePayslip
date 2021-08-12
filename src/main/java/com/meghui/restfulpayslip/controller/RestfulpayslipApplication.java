package com.meghui.restfulpayslip.controller;

import com.meghui.restfulpayslip.entities.Employee;
import com.meghui.restfulpayslip.utils.Generator;
import com.meghui.restfulpayslip.entities.PaySlip;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class RestfulpayslipApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulpayslipApplication.class, args);
    }

    @PostMapping("/payslip")
    public ArrayList<PaySlip> payslippost(@RequestBody ArrayList<Employee> employees) throws Exception {
        ArrayList<PaySlip> paySlips = new ArrayList<>();
        for(Employee emp: employees){
            Generator generator = new Generator();
            paySlips.add(generator.generatePaySlip(emp));
        }
        return paySlips;
    }
}
