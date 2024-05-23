package implementation;

import DAO.TaskDao;
import modals.Task;
import modals.Ressources;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO task (idTask, title, description, dateDebutTache, dateFinTache, statut, idProject) VALUES (?,?,?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, task.getIdTask());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setDate(4, task.getDateDebutTache());
            statement.setDate(5, task.getDateFinTache());
            statement.setString(6, task.getStatus().toString()); // Utilisation de l'énumération
            statement.setInt(7, task.getProjectId());
            statement.execute();
        }
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
    public List<Task> getTasks() {
        return List.of();
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
}

