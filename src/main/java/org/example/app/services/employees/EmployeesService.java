package org.example.app.services.employees;

import org.example.app.controllers.employees.EmployeesCreateController;
import org.example.app.controllers.employees.EmployeesReadController;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.employees.EmployeesCreateRepository;
import org.example.app.repositories.employees.EmployeesReadRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeCreateView;
import org.example.app.views.employees.EmployeesReadView;

public class EmployeesService {

    public void createEmployee(){
        EmployeesCreateRepository repository = new EmployeesCreateRepository();
        EmployeesCreateService service = new EmployeesCreateService(repository);
        EmployeeCreateView view = new EmployeeCreateView();
        EmployeesCreateController controller = new EmployeesCreateController(view, service);
        controller.createEmployees();

    }

    public void readEmployee(){
        EmployeesReadRepository repository = new EmployeesReadRepository();
        EmployeesReadService service = new EmployeesReadService(repository);
        EmployeesReadView view = new EmployeesReadView();
        EmployeesReadController controller = new EmployeesReadController(service, view);
        controller.readEmployees();

    }


    public void getNoSuchOption(int choice){
        int [] menuChoice = {0, 1, 2};
        if (contains(menuChoice, choice)){
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e){
                System.out.println(e.getMessage());
                AppStarter.startApp();        // Нужно проверить!
            }
        }

    }

    public static boolean contains(final int [] options, final int value){
        boolean  result = false;
        for (int i: options){
            if (i == value){
                result = true;
                break;
            }
        }
        return result;
    }

}
