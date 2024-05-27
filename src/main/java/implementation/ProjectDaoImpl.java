package implementation;

import DAO.ProjectDao;
import DTO.ProjectData;
import modals.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    public Connection connection;



    @Override
    public Project createProject(Project project) throws SQLException {
        String sql = "INSERT INTO project (projectName, description, budget, dateDebut, dateFin) VALUES (?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();
        Project pr = new Project();

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getDescription());
            statement.setDouble(3, project.getBudget());
            statement.setDate(4, project.getDateDebut());
            statement.setDate(5, project.getDateFin());
            statement.executeUpdate();

           PreparedStatement statement1 = con.prepareStatement("select * from project where projectName = ?");
            statement1.setString(1, project.getProjectName());
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()) {
                pr.setId(resultSet.getInt("id"));
                pr.setProjectName(resultSet.getString("projectName"));
                pr.setDescription(resultSet.getString("description"));
                pr.setBudget(resultSet.getDouble("budget"));
                pr.setDateDebut(resultSet.getDate("dateDebut"));
                pr.setDateFin(resultSet.getDate("dateFin"));
            }
            return pr;

        }

    }

    @Override
    public void updateProject(Project project) throws SQLException {
        String sql="UPDATE project SET projectName=?,description =?,budget=?,dateDebut=?,dateFin=? WHERE id=? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, project.getId());
            statement.setString(2, project.getProjectName());
            statement.setString(3, project.getDescription());
            statement.setDouble(4, project.getBudget());
            statement.setDate(5, project.getDateDebut());
            statement.setDate(6, project.getDateFin());
            statement.executeUpdate();

        }


    }

    @Override
    public void deleteProject(Project project) throws SQLException {
        String sql = "DELETE FROM project WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, project.getId());
            statement.executeUpdate();

        }

    }

    @Override
    public Project getProject(int id) throws SQLException {
        Project project = null;
        String sql = "SELECT * FROM project WHERE id=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    project = new Project();
                    project.setId(resultSet.getInt("id"));
                    project.setProjectName(resultSet.getString("projectName"));
                    project.setDescription(resultSet.getString("description"));
                    project.setBudget(resultSet.getDouble("Budget"));
                    project.setDateDebut(resultSet.getDate("dateDebut"));
                    project.setDateFin(resultSet.getDate("dateFin"));


                    return project;
                }
            }}
            return null;

    }

    @Override
    public List<Project> getProjects() throws SQLException {
        String sql = "SELECT * FROM project";
        List<Project> projects = new ArrayList<Project>();
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            Project project = new Project();

            project.setProjectName(resultSet.getString("projectName"));
            project.setDescription(resultSet.getString("description"));
            project.setBudget(resultSet.getDouble("Budget"));
            project.setDateDebut(resultSet.getDate("dateDebut"));
            project.setDateFin(resultSet.getDate("dateFin"));
            projects.add(project);
        }

        return projects;



    }
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
@Override
public List<ProjectData> getAllProjectsData() throws SQLException {
    List<ProjectData> projectDataList = new ArrayList<>();

    String projectQuery = "SELECT * FROM project";
    try (Connection con = Connectiondb.getConnection();
         PreparedStatement projectStatement = con.prepareStatement(projectQuery);
         ResultSet projectResult = projectStatement.executeQuery()) {

        while (projectResult.next()) {
            int projectId = projectResult.getInt("id");
            String projectName = projectResult.getString("projectName");
            String description = projectResult.getString("description");
            double budget = projectResult.getDouble("budget");
            Date dateDebut = projectResult.getDate("dateDebut");
            Date dateFin = projectResult.getDate("dateFin");

            int totalTasks = 0; // Initialiser le nombre total de tâches à zéro

            // Récupérer le nombre total de tâches pour ce projet en exécutant une requête SQL
            String totalTasksQuery = "SELECT COUNT(*) AS totalTasks FROM task WHERE idProject = ?";
            try (PreparedStatement totalTasksStatement = con.prepareStatement(totalTasksQuery)) {
                totalTasksStatement.setInt(1, projectId);
                try (ResultSet totalTasksResult = totalTasksStatement.executeQuery()) {
                    if (totalTasksResult.next()) {
                        totalTasks = totalTasksResult.getInt("totalTasks");
                    }
                }
            }

            int doneTasks = 0; // Récupérer le nombre de tâches terminées pour ce projet
            String doneTasksQuery = "SELECT COUNT(*) AS doneTasks FROM task WHERE idProject = ? AND statut = 'FAITE'";
            try (PreparedStatement doneTasksStatement = con.prepareStatement(doneTasksQuery)) {
                doneTasksStatement.setInt(1, projectId);
                try (ResultSet doneTasksResult = doneTasksStatement.executeQuery()) {
                    if (doneTasksResult.next()) {
                       doneTasks=doneTasksResult.getInt("doneTasks");
                    }
                }
            }
            Project project = new Project(projectId, projectName, description, budget, dateDebut, dateFin);
            ProjectData projectData = new ProjectData(project, doneTasks, totalTasks);
            projectDataList.add(projectData);
        }
    }

    return projectDataList;
}
    @Override
    public Integer getNumberOfTotalProjectOverall() throws SQLException{
        String sql = "SELECT count(id) FROM project  ";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

}
