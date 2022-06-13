package com.mindex.challenge.data;

public class Compensation {
    private Employee employee;
    private int salary;
    private String effectiveDate;

    public Compensation(){
        
    }
    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee newEmployee){
        this.employee = newEmployee;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int newSalary){
        this.salary = newSalary;
    }

    public String getEffectiveDate(){
        return effectiveDate;
    }

    public void setEffectiveDate(String newEffectiveDate){
        this.effectiveDate = newEffectiveDate;
    }
}
