package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeesCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeCreateView;

import java.sql.Date;

public class EmployeesCreateController {
    EmployeeCreateView view;
    EmployeesCreateService service;

    public EmployeesCreateController(EmployeeCreateView view, EmployeesCreateService service) {
        this.view = view;
        this.service = service;
    }

    public void createEmployees(){
        String[] data = view.getData();
        Employee employee = new Employee();
        employee.setFirstName(data[0]);
        employee.setLastName(data[1]);
        employee.setBirthDate(Date.valueOf(data[2]));
        employee.setPositionId(Integer.parseInt(data[3]));
        employee.setPhone((data[4]));
        employee.setSalary(Double.parseDouble(data[5]));
        String str = service.createEmployee(employee);
        view.getOutput(str);
        AppStarter.startApp();


    }
}
