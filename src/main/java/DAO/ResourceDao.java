package DAO;
import modals.Resource;
import modals.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ResourceDao {
    void addResource(Resource resource) throws SQLException;
    void updateResource(Resource resource) throws SQLException;
    void deleteResource(int resourceId) throws SQLException;
    Resource getResourceById(int resourceId) throws SQLException;
    List<Resource> getResourcesByTaskId(int taskId) throws SQLException;
    List<Resource> getAllResources() throws SQLException;
}
