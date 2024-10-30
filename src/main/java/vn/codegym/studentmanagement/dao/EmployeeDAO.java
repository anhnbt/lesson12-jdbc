package vn.codegym.studentmanagement.dao;

import vn.codegym.studentmanagement.connection.DBConnection;
import vn.codegym.studentmanagement.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/30
 * Time: 13:48
 */
public class EmployeeDAO {

    private DBConnection dbConnection = new DBConnection();

    public List<Employee> getAllEmployees(String jobTitle) {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        try {
            conn = dbConnection.getConnection();
            callableStatement = conn.prepareCall("{call getAllEmployees(?)}");
            callableStatement.setString(1, jobTitle);
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeNumber(rs.getInt("employeeNumber"));
                employee.setLastName(rs.getString("lastName"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setEmail(rs.getString("email"));
                employee.setJobTitle(rs.getString("jobTitle"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public boolean save(Employee employee) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int recordAffected = 0;
        try {
            conn = dbConnection.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employee.getEmployeeNumber());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getExtension());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getOfficeCode());
            if (employee.getReportsTo() == null) {
                preparedStatement.setNull(7, Types.NULL);
            } else {
                preparedStatement.setInt(7, employee.getReportsTo());
            }
            preparedStatement.setString(8, employee.getJobTitle());
            recordAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recordAffected > 0;
    }
}
