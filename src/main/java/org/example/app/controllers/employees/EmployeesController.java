package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeesService;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeesView;

public class EmployeesController {
    EmployeesView view;
    EmployeesService service;


    public EmployeesController(EmployeesView view, EmployeesService service) {
        this.view = view;
        this.service = service;
    }
    public void runEmployees(){
        filterChoice(view.chooseOption());

    }

    private void filterChoice(int choice){
        switch (choice){
            case 1 -> service.createEmployee();
            case 2 -> service.readEmployee();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);

        }
    }
}
