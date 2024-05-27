package implementation;

import DAO.EmployeeDao;
import modals.Employee;
import modals.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        Employee employee = null;
        String sql = "select * from employees where idEmployee = ?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("idEmployee"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setDepartement(resultSet.getString("department"));
                employee.setPicture(resultSet.getString("picture"));

            }

        }return employee;
    }
    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = null;
        String sql = "select * from employees";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            employees = new ArrayList<Employee>();
            while (resultSet.next()) {

                Employee employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("idEmployee"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setDepartement(resultSet.getString("department"));
                employee.setPicture(resultSet.getString("picture"));
                employees.add(employee);

            }
            return employees;
        }
    }

}
