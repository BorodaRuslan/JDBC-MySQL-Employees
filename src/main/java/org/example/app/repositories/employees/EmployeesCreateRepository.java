package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesCreateRepository {

    public String createEmployees(Employee employee){
        String sql = "INSERT INTO " + Constants.TABLE_EMPLOYEES + " (lastName, firstName, birthDate, positionId, phone, salary) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = DBConn.connect().prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setDate(3, Date.valueOf("1990-05-05"));     // Поменял формат даты
            preparedStatement.setInt(4, employee.getPositionId());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.executeUpdate();
            return Constants.INCORRECT_VALUE_MSG;
        } catch (SQLException e){
            return e.getMessage();
        }
    }
}
