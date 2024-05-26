package DAO;

import modals.Resource;
import modals.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    Task addTask(Task task) throws SQLException;
    void updateTask(Task task) throws SQLException;

    void updateTaskStatus(Task task) throws SQLException;

    void setTaskStatusEN_COURS(int idTask) throws SQLException;

    void deleteTask(Task task) throws SQLException;
    Task getTaskById(int id) throws SQLException;

    Integer getNumberOfTasksByStatus(String status, int id) throws SQLException;


    Integer getNumberOfTotalTasks(int id) throws SQLException;

    Integer getNumberOfOveralltasksByStatus()throws SQLException;

    List<Task> getTasksByStatus(String status, int projectId) throws SQLException;

    Integer getNumberOfTotalTasksoOverall() throws SQLException;

    List<Task> getTasks();
    public List<Task> getTaskByProject(int idProjet) throws SQLException;

    void associateTaskWithProject(int taskId, int projectId) throws SQLException;

    void addResourcesToTask(int taskId, List<Resource> resourcesToAdd) throws SQLException;
}
