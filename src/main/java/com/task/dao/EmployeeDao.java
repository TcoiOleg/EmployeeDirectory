package com.task.dao;

import com.task.xml.entities.Employee;
import com.task.xml.entities.Employees;
import com.task.xml.entities.Unit;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 26.02.2017.
 */
public class EmployeeDao {

    private Employees employees;

    public EmployeeDao(Employees employees) {
        this.employees = employees;
    }

    public Employee create(String unitParent, Employee employeeTemplate) {
        Unit u = (Unit) employees.find(unitParent);
        UUID idOne = UUID.randomUUID();
        employeeTemplate.setId(idOne.hashCode());
        if (u != null) {
            u.getEmployee().add(employeeTemplate);
        } else {
            u = new Unit();
            u.setName(unitParent);
            u.setEmployee(new ArrayList<Employee>() {{add(employeeTemplate);}});
            employees.getUnit().add(u);
        }
        return employeeTemplate;
    }

    public Employee update(Employee employeeTemplate) {
        UUID idOne = UUID.randomUUID();
        employeeTemplate.setId(idOne.hashCode());
        return employeeTemplate;
    }

    public void delete(int employeeId) {

    }
}
