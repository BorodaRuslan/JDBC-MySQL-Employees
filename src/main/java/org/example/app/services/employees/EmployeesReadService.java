package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeesReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeesReadService {
    EmployeesReadRepository repository;

    public EmployeesReadService(EmployeesReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployees(){

        List<Employee> list = repository.readEmployees();

        if (list != null){
            if (!list.isEmpty()){
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((employee ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") FirstName: ")
                                .append(employee.getFirstName())
                                .append(",")
                                .append("LastName: ")
                                .append(employee.getLastName())
                                .append(",")
                                .append(" BirthDate: ")
                                .append(employee.getBirthDate())
                                .append(",")
                                .append(" PositionId: ")
                                .append(employee.getPositionId())
                                .append(",")
                                .append("  phone: ")
                                .append(",")
                                .append(employee.getPhone())
                                .append("  Salary: ")
                                .append(employee.getSalary())
                                .append("\n")));
                return "\n Employees____________________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;

        } else return Constants.DATA_ABSENT_MSG;
    }
}
