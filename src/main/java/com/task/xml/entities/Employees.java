package com.task.xml.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Employees {

    private List<Unit> unit;

    public List<Unit> getUnit() {
        return unit;
    }

    @XmlElement
    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }

    public Object find(String unitName) {
        List<Unit> units = this.unit;
        for (Unit u : units) {
            Object finded = find(unitName, u);
            if (finded != null) { return finded; }
        }
        return null;
    }

    private Object find(String match, Unit place) {
        if (match.equals(place.getName())) {
            return place;
        }
        if (place.getEmployee() != null) {
            for (Employee e : place.getEmployee()) {
                if (match.equals(e.getFio())) {
                    return e;
                }
            }
        }
        if (place.getUnit() != null) {
            for (Unit u : place.getUnit()) {
                Object f = find(match, u);
                if (f != null) {
                    return f;
                }
            }
        }
        return null;
    }
}
