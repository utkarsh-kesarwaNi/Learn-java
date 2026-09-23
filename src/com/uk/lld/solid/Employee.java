package com.uk.lld.solid;

public class Employee {

    private String name;
    private double hoursWorked;

    public double calculatePay() { /* ... */
        return 0;
    }

    public void save() { /* raw SQL to save employee ... */ }

    public String generateReport() { /* ... */
        return "Report";
    }
}

/*
* Single Responsibility Principle (SRP) states that a software module, class or function should have one and only one reason to change.
* SRP is the ultimate measure of High Cohesion.
*
* Employee class has more than one reason to change:
* 1. calculatePay() can change as per new Tax rules.
* 2. save() can change based on if we want to save to database or file.
* 3. generateReport() can change based on generating report in multiple formats(pdf, csv, txt)
*
* Employee class violates SRP.
*
*
* SOLUTION
*
* public class PayCalculator {
    public BigDecimal calculatePay(Employee employee) {
        // Complex business rules, overtime, taxes, etc.
        return employee.hourlyRate().multiply(BigDecimal.valueOf(employee.hoursWorked()));
    }
}
*
* public class EmployeeRepository {
    public void saveToDB(Employee employee) {
        System.out.println("Saving " + employee.id() + " to the database.");
    }
    public void saveToFile(Employee employee) {
        System.out.println("Saving " + employee.id() + " to the file.");
    }
}
*
* public class EmployeeReportFormatter {
    public String format(Employee employee, BigDecimal calculatedPay) {
        return String.format("Employee: %s, Payout: $%s", employee.name(), calculatedPay);
    }
}
* */