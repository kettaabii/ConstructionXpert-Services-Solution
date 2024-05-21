package DAO;

import modals.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    void createProject(Project project) throws SQLException;
    void updateProject(Project project) throws SQLException;
    void deleteProject(Project project) throws SQLException;
    Project getProject(int id) throws SQLException;
    List<Project> getProjects();


}
