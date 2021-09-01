# restfulpayslip

restfulpayslip

JDK: 11 IDE: Intellij IDEA Sprint Boot: 2.5.3 Gradle

Github: https://github.com/meghui/RestApiGradlePayslip

API Demo on AWS: http://ec2-18-119-104-40.us-east-2.compute.amazonaws.com:8080/payslip

SUMMARY

This is RESTFUL API to receive a list of employees information and return their payslips, using JSON format.

USAGE

Please use POST http request as the client needs to provide multiple employee data to the server.

Body format for POST request and a sample:

[{"firstName":"David","lastName":"Rudd","annualSalary":60050,"startDateOfPayment":"1 March","superRate":0.09},{"firstName":"Ryan","lastName":"Chen","annualSalary":120000,"startDateOfPayment":"1 March","superRate":0.1},{"firstName":"David","lastName":"Rudd","annualSalary":60050,"startDateOfPayment":"1 March","superRate":0.09},{"firstName":"Ryan","lastName":"Chen","annualSalary":120000,"startDateOfPayment":"1 March","superRate":0.1}]

use RAW data format

CONFIGURATION FILE

please modify taxrates.json to change income thresholds and tax rates.
