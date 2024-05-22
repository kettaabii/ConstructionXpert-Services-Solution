package DAO;
import modals.Ressources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ResourceDao {
    void addResource(Ressources resource) throws SQLException;
    void updateResource(Ressources resource) throws SQLException;
    void deleteResource(int resourceId) throws SQLException;
    Ressources getResourceById(int resourceId) throws SQLException;
    List<Ressources> getResourcesByTaskId(int taskId) throws SQLException;
    List<Ressources> getAllResources() throws SQLException;
}
