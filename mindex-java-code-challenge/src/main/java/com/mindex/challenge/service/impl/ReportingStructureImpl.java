package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;


@Service
public class ReportingStructureImpl {
    @Autowired
    private EmployeeService employeeService;

    public ReportingStructureImpl(EmployeeService numEmployeeService){
        employeeService = numEmployeeService;
    }

    public ReportingStructure getReportingStructure(String id){
        Employee e = employeeService.read(id);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(e);

        //TO SET THE NUMBER OF REPORTS, GET THE TOTAL OF REPORTS BASED ON NUMBER OF EMPLOYEES
        reportingStructure.setNumberOfReports(getTotalReports(e));
        return reportingStructure;
    }

    //FUNCTION FOR GETTING TOTAL REPORTS FOR EACH EMPLOYEE
    public int getTotalReports(Employee numEmployee){
        int numReports = 0;

        //return 0 for number of reports if there are no EMPLOYEES
        if(numEmployee.getDirectReports() == null){
            return numReports;
        }
        else{
            //OTHERWISE, ITERATE THROUGH NUMBER OF REPORTS AND THEN RETURN THAT NUMBER
            numReports += numEmployee.getDirectReports().size();


            for(Employee totalEmployees : numEmployee.getDirectReports()){

                numReports += getTotalReports(employeeService.read(totalEmployees.getEmployeeId()));
            }
            return numReports;
        }
    }
}
