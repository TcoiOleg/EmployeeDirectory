package com.task;

import com.task.xml.entities.Employee;
import com.task.xml.entities.Employees;
import com.task.xml.entities.Unit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet("/EmployeeList")
public class ShowEmployeeServlet extends HttpServlet {

    private static final String CHARSET_NAME = "UTF-8";
    private static final long PERIOD = 60000L;

    public static volatile Employees employees;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        class FillEmployeeTask extends TimerTask {
            @Override
            public void run() {
                File employeeFile = new File(getServletContext().getRealPath("/employee.xml"));
                try {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    employees = (Employees) unmarshaller.unmarshal(employeeFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask fillTask = new FillEmployeeTask();
        fillTask.run();
        new Timer().schedule(fillTask, 0, PERIOD);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(CHARSET_NAME);
        if (employees == null) {
            resp.getWriter().println("There is no employee list!");
            return;
        }
        for (Unit u : employees.getUnit()) {
            printUnit(resp, "", u);
        }
    }

    private void printUnit(HttpServletResponse resp, String tab, Unit unit) throws IOException {
        resp.getWriter().println(tab + unit.getName());
        tab = tab + "\t";
        if (unit.getEmployee() != null) {
            for (Employee employee : unit.getEmployee()) {
                resp.getWriter().println(tab + employee.toString());
            }
        }
        if (unit.getUnit() != null) {
            for (Unit innerUnit : unit.getUnit()) {
                printUnit(resp, tab + "\t", innerUnit);
            }
        }
        resp.getWriter().println();
    }
}