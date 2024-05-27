package DAO;

import modals.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    Employee getEmployeeById(int id) throws SQLException;

    List<Employee> getAllEmployees() throws SQLException;
}
