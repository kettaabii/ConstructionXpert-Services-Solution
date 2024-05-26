package implementation;

import DAO.ResourceDao;
import modals.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {

    @Override
    public void addResource(Resource resource) throws SQLException {
        String sql = "INSERT INTO ressources (ressourceId,ressourceName,ressourceDesctription,quantity,supplier,idTask) VALUES (?,?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, resource.getResourceId());
            statement.setString(2, resource.getResourceName());
            statement.setString(3, resource.getResourceDescription());
            statement.setInt(4, resource.getQuantity());
            statement.setString(5, resource.getSupplier());
            statement.setInt(6, resource.getTaskId());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateResource(Resource resource) throws SQLException {
        String sql = "UPDATE constructionxpert.ressources SET ressourceName=?, ressourceDesctription=?, quantity=?, supplier=?, idTask=? WHERE ressourceId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, resource.getResourceName());
            statement.setString(2, resource.getResourceDescription());
            statement.setInt(3, resource.getQuantity());
            statement.setString(4, resource.getSupplier());
            statement.setInt(5, resource.getTaskId());
            statement.setInt(6, resource.getResourceId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteResource(int resourceId) throws SQLException {
        String sql = "DELETE FROM ressources WHERE ressourceId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, resourceId);
            statement.executeUpdate();
        }
    }

    @Override
    public Resource getResourceById(int resourceId) throws SQLException {
        String sql = "SELECT * FROM ressources WHERE ressourceId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, resourceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Resource(
                            resultSet.getInt("ressourceId"),
                            resultSet.getString("ressourceName"),
                            resultSet.getString("ressourceDesctription"),
                            resultSet.getInt("quantity"),
                            resultSet.getString("supplier"),
                            resultSet.getInt("idTask")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Resource> getResourcesByTaskId(int taskId) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        String sql = "SELECT * FROM ressources WHERE idTask=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, taskId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    resources.add(new Resource(
                            resultSet.getInt("resourceId"),
                            resultSet.getString("resourceName"),
                            resultSet.getString("resourceDescription"),
                            resultSet.getInt("quantity"),
                            resultSet.getString("supplier"),
                            resultSet.getInt("idTask")
                    ));
                }
            }
        }
        return resources;
    }

    @Override
    public List<Resource> getAllResources() throws SQLException {
        List<Resource> resources = new ArrayList<>();
        String sql = "SELECT * FROM ressources";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                resources.add(new Resource(
                        resultSet.getInt("ressourceId"),
                        resultSet.getString("ressourceName"),
                        resultSet.getString("ressourceDesctription"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("supplier"),
                        resultSet.getInt("idTask")
                ));
            }
        }
        return resources;
    }
}

