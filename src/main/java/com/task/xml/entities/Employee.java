package com.task.xml.entities;


import com.google.common.base.Joiner;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

    private int id;
    private String fio;
    private String position;
    private String email;
    private String tel;
    private String tel2;
    private String room;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    @XmlAttribute
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    @XmlAttribute
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    @XmlAttribute
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    @XmlAttribute
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    @XmlAttribute
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getRoom() {
        return room;
    }

    @XmlAttribute
    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return tel2 != null ? Joiner.on(", ").join(fio, position, email, tel, tel2, room) :
                Joiner.on(", ").join(fio, position, email, tel, room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (fio != null ? !fio.equals(employee.fio) : employee.fio != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (room != null ? !room.equals(employee.room) : employee.room != null) return false;
        if (tel != null ? !tel.equals(employee.tel) : employee.tel != null) return false;
        if (tel2 != null ? !tel2.equals(employee.tel2) : employee.tel2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (tel2 != null ? tel2.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }
}
