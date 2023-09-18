package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeesReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeesReadView;

public class EmployeesReadController {
    EmployeesReadService service;
    EmployeesReadView view;


    public EmployeesReadController(EmployeesReadService service, EmployeesReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployees(){
        String str = service.readEmployees();

        view.getOutput(str);
        AppStarter.startApp();
    }
}
