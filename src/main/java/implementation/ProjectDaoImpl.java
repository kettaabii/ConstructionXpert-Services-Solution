package implementation;

import DAO.ProjectDao;
import modals.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    public Connection connection;



    @Override
    public void createProject(Project project) throws SQLException {
        String sql = "INSERT INTO project (id, projectName, description, budget, dateDebut, dateFin) VALUES (?,?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();

        try (PreparedStatement statement = con.prepareStatement(sql)) {
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
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
}
