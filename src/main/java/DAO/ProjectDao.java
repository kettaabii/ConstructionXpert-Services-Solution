package DAO;

import DTO.ProjectData;
import modals.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    Project createProject(Project project) throws SQLException;
    Project updateProject(Project project) throws SQLException;
    void deleteProject(Project project) throws SQLException;
    Project getProject(int id) throws SQLException;
    List<Project> getProjects() throws SQLException;


//    ProjectData getProjectData(int projectId) throws SQLException;

    //    @Override
    //    public ProjectData getProjectData(int projectId) throws SQLException {
    //        String projectQuery = "SELECT * FROM project WHERE id = ?";
    //        String totalTasksQuery = "SELECT COUNT(*) AS totalTasks FROM task WHERE idProject = ?";
    //        String doneTasksQuery = "SELECT COUNT(*) AS doneTasks FROM task WHERE idProject = ? AND statut = 'Faite'";
    //
    //        Connection con = Connectiondb.getConnection();
    //        try {
    //            // Récupérer les informations sur le projet
    //            PreparedStatement projectStatement = con.prepareStatement(projectQuery);
    //            projectStatement.setInt(1, projectId);
    //            ResultSet projectResult = projectStatement.executeQuery();
    //            Project project = null;
    //            if (projectResult.next()) {
    //                int id = projectResult.getInt("id");
    //                String projectName = projectResult.getString("projectName");
    //                String description = projectResult.getString("description");
    //                double budget = projectResult.getDouble("budget");
    //                Date dateDebut = projectResult.getDate("dateDebut");
    //                Date dateFin = projectResult.getDate("dateFin");
    //                project = new Project(id, projectName, description, budget, dateDebut, dateFin);
    //            }
    //
    //            // Récupérer le nombre total de tâches pour ce projet
    //            PreparedStatement totalTasksStatement = con.prepareStatement(totalTasksQuery);
    //            totalTasksStatement.setInt(1, projectId);
    //            ResultSet totalTasksResult = totalTasksStatement.executeQuery();
    //            int totalTasks = 0;
    //            if (totalTasksResult.next()) {
    //                totalTasks = totalTasksResult.getInt("totalTasks");
    //            }
    //
    //            // Récupérer le nombre de tâches avec le statut "Faite" pour ce projet
    //            PreparedStatement doneTasksStatement = con.prepareStatement(doneTasksQuery);
    //            doneTasksStatement.setInt(1, projectId);
    //            ResultSet doneTasksResult = doneTasksStatement.executeQuery();
    //            int doneTasks = 0;
    //            if (doneTasksResult.next()) {
    //                doneTasks = doneTasksResult.getInt("doneTasks");
    //            }
    //
    //            return new ProjectData(project, doneTasks, totalTasks);
    //        } finally {
    //            con.close(); // Fermer la connexion à la base de données
    //        }
    //    }
    List<ProjectData> getAllProjectsData() throws SQLException;

    Integer getNumberOfTotalProjectOverall() throws SQLException;
}
