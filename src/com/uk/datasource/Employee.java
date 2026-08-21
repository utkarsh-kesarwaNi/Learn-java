package com.uk.datasource;

public class Employee {
    private final String employeeName;
    private final String employeeDepartment;
    private final Long employeeSalary;

    public Employee(String employeeName, String employeeDepartment, Long employeeSalary) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
