package com.task.xml.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Unit {

    private List<Employee> employee;
    private String name;
    private List<Unit> unit;

    public List<Employee> getEmployee() {
        return employee;
    }

    @XmlElement
    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getUnit() {
        return unit;
    }

    @XmlElement
    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "employee=" + employee +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}
