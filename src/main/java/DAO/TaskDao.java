package DAO;

import modals.Task;

import java.util.List;

public interface TaskDao {
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(Task task);
    Task getTask(int id);
    List<Task> getTasks();

}
