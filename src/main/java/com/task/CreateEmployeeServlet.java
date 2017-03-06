package com.task;

import com.task.dao.EmployeeDao;
import com.task.xml.entities.Employee;
import com.task.xml.entities.Employees;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

/**
 * OLTS on 26.02.2017.
 */
@WebServlet("/employee/create")
public class CreateEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (ShowEmployeeServlet.employees) {
            String unitName = req.getParameter("unitName");
            String fio = req.getParameter("fio");
            String position = req.getParameter("position");
            String email = req.getParameter("email");
            String tel = req.getParameter("tel");
            String tel2 = req.getParameter("tel2");
            String room = req.getParameter("room");
            Employee employee = new Employee();
            employee.setFio(fio);
            employee.setPosition(position);
            employee.setEmail(email);
            employee.setTel(tel);
            employee.setTel2(tel2);
            employee.setRoom(room);
            new EmployeeDao(ShowEmployeeServlet.employees).create(unitName, employee);
            updateEmployees(ShowEmployeeServlet.employees);
        }
    }

    private void updateEmployees(Employees employees) {
        File employeeFile = new File(getServletContext().getRealPath("/employee.xml"));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(employees, employeeFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
