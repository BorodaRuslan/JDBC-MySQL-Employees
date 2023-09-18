package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.exceptions.PositionCreateException;
import org.example.app.repositories.employees.EmployeesCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EmployeesCreateService {

    EmployeesCreateRepository repository;

    public EmployeesCreateService(EmployeesCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(Employee employee){
        Map<String, String> errors = new HashMap<>();

        if (employee.getFirstName().isEmpty())
            errors.put("Last name", Constants.INPUT_REQ_MSG);
            errors.put("First name", Constants.INPUT_REQ_MSG);
            errors.put("Birth date", Constants.INPUT_REQ_MSG);
            errors.put("Position Id", Constants.INPUT_REQ_MSG);
            errors.put("Phone", Constants.INPUT_REQ_MSG);
            errors.put("Salary", Constants.INPUT_REQ_MSG);

        if (!errors.isEmpty()){
            try {
                throw new PositionCreateException("Check inputs", errors);
            } catch (PositionCreateException e){
                return e.getErrors(errors);
            }
        }
        return repository.createEmployees(employee);
    }
}
