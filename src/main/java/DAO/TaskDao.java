package DAO;

import modals.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    void addTask(Task task) throws SQLException;
    void updateTask(Task task) throws SQLException;

    void updateTaskStatus(Task task) throws SQLException;

    void deleteTask(Task task) throws SQLException;
    Task getTaskById(int id) throws SQLException;
    List<Task> getTasks();
    public List<Task> getTaskByProject(int idProjet) throws SQLException;
}
