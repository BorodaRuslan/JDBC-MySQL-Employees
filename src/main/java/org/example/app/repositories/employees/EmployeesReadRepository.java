package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesReadRepository {

    List<Employee> list;

    public List<Employee> readEmployees() {

        try (Statement statement = DBConn.connect().createStatement()) {
            list = new ArrayList<>();

            String sql = "SELECT id, name FROM" + Constants.TABLE_EMPLOYEES;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setLastName(rs.getString("lastName"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setBirthDate(rs.getDate("birthDate"));
                employee.setPositionId(rs.getInt("positionId"));
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));
                list.add(employee);

            }
            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
