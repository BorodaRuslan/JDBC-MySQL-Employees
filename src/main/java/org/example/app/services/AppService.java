package org.example.app.services;

import org.example.app.controllers.employees.EmployeesController;
import org.example.app.controllers.positions.PositionController;
import org.example.app.exceptions.OptionException;
import org.example.app.services.employees.EmployeesService;
import org.example.app.services.positions.PositionService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeesView;
import org.example.app.views.positions.PositionView;

public class AppService {

    public void getPositions() {
        PositionView view = new PositionView();
        PositionService service = new PositionService();
        PositionController controller = new PositionController(view, service);
        controller.runPositions();
    }

    public void getEmployees() {
        EmployeesView view = new EmployeesView();
        EmployeesService service = new EmployeesService();
        EmployeesController controller = new EmployeesController(view, service);
        controller.runEmployees();
        System.out.println("Employees actions");
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2};
        if (!hasOption(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean hasOption(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
