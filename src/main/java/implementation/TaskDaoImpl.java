package implementation;

import DAO.TaskDao;
import modals.Resource;
import modals.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public Task addTask(Task task) throws SQLException {
        String sql = "INSERT INTO task ( title, description, dateDebutTache, dateFinTache, statut, idProject) VALUES (?,?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();

        try (PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDateDebutTache());
            statement.setDate(4, task.getDateFinTache());
            statement.setString(5, task.getStatus().toString()); // Utilisation de l'énumération
            statement.setInt(6, task.getProjectId());
            statement.execute();
        }
        return task;
    }

    @Override
    public void updateTask(Task task) throws SQLException {
        String sql = "UPDATE task SET title=?,description=?,dateDebutTache=?,dateFinTache=?,statut=?,idProject=? WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDateDebutTache());
            statement.setDate(4, task.getDateFinTache());
            statement.setString(5, task.getStatus().toString()); // Utilisation de l'énumération
            statement.setInt(6, task.getProjectId());
            statement.setInt(7, task.getIdTask());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateTaskStatus(Task task) throws SQLException {
        String sql = "UPDATE task SET statut=? WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, task.getStatus().toString()); // Utilisation de l'énumération
            statement.setInt(2, task.getIdTask());
            statement.executeUpdate();
        }
    }
    @Override
    public void setTaskStatusEN_COURS(int idTask) throws SQLException {
        String sql = "UPDATE task SET statut=? WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, Task.Status.EN_COURS.toString());
            statement.setInt(2, idTask);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteTask(Task task) throws SQLException {
        String sql = "DELETE FROM task WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, task.getIdTask());
            statement.executeUpdate();
        }
    }

    @Override
    public Task getTaskById(int id) throws SQLException {
        String sql = "SELECT * FROM task WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idTask = resultSet.getInt("idTask");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date dateDebutTache = resultSet.getDate("dateDebutTache");
                Date dateFinTache = resultSet.getDate("dateFinTache");
                Task.Status status = Task.Status.valueOf(resultSet.getString("statut")); // Utilisation de l'énumération
                int projectId = resultSet.getInt("idProject");
                Task task = new Task(idTask, title, description, dateDebutTache, dateFinTache, status, projectId); // Passage du statut en tant qu'énumération
                return task;
            }
        }
        return null;
    }
    @Override
    public Integer getNumberOfTasksByStatus(String status, int id) throws SQLException{
        String sql = "SELECT count(idTask) FROM task WHERE statut=? AND idProject=? ";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }
    @Override
    public Integer getNumberOfTotalTasks(int id) throws SQLException{
        String sql = "SELECT count(idTask) FROM task WHERE  idProject=? ";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    @Override
    public Integer getNumberOfOveralltasksByStatus() throws SQLException {
        return 0;
    }
    @Override
    public List<Task> getTasksByStatus(String status, int projectId) throws SQLException {
        String sql = "SELECT * FROM task WHERE statut=? AND idProject=? ";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, projectId);
            ResultSet resultSet = statement.executeQuery();
            List<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idTask");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date dateDebutTache = resultSet.getDate("dateDebutTache");
                Date dateFinTache = resultSet.getDate("dateFinTache");

               Task task =new Task(idTask,title,description,dateDebutTache,dateFinTache,Task.Status.valueOf(status),projectId);

                tasks.add(task);
            }
        return tasks;
        }
    }

    @Override
    public Integer getNumberOfTotalTasksoOverall() throws SQLException{
        String sql = "SELECT count(idTask) FROM task  ";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }



    public List<Task> getTaskByProject(int idProjet) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM task WHERE idProject = ?";
        Connection con = Connectiondb.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, idProjet);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idTask");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date dateDebutTache = resultSet.getDate("dateDebutTache");
                Date dateFinTache = resultSet.getDate("dateFinTache");
                Task.Status status = Task.Status.valueOf(resultSet.getString("statut")); // Utilisation de l'énumération
                int assignedEmployeeId = resultSet.getInt("assignedEmployeeId");

                // Créer la tâche avec les informations récupérées
                Task task = new Task(idTask, title, description, dateDebutTache, dateFinTache, status, idProjet);
                task.setAssignedEmployeeId(assignedEmployeeId);
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(); // Fermer la connexion à la base de données
        }
    }
    @Override
    public void associateTaskWithProject(int taskId, int projectId) throws SQLException {
        String sql = "UPDATE task SET idProject = ? WHERE idTask = ?";
        try (Connection con = Connectiondb.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            statement.setInt(2, taskId);
            statement.executeUpdate();
        }
    }
    @Override
    public void addResourcesToTask(int taskId, List<Resource> resourcesToAdd) throws SQLException {
        String sql ="INSERT INTO taskresource (taskId, resourceId) VALUES (?,?)";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, taskId);
        statement.setInt(2, resourcesToAdd.size());
        statement.executeUpdate();
        statement.close();

    }
    @Override
    public void updateEmployeeId(int taskId,int  employeeId) throws SQLException{
        String sql = "UPDATE task SET assignedEmployeeId = ? WHERE idTask = ?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1,employeeId);
            statement.setInt(2, taskId);
            statement.executeUpdate();
            statement.close();
        }
    }
}

