package implementation;

import DAO.ResourceDao;
import modals.Ressources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {

    @Override
    public void addResource(Ressources resource) throws SQLException {
        String sql = "INSERT INTO ressources (ressourceId,ressourceName,ressourceDesctription,quatntity,supplier,taskId) VALUES (?,?,?,?,?,?)";
        Connection con = Connectiondb.getConnection();

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, resource.getRessourceId());
            statement.setString(2, resource.getRessourceName());
            statement.setString(3, resource.getRessourceDescription());
            statement.setInt(4, resource.getQuantity());
            statement.setString(5, resource.getSupplier());
            statement.setInt(6, resource.getIdTask());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateResource(Ressources resource) throws SQLException {
        String sql = "UPDATE constructionxpert.ressources SET ressourceName=?, ressourceDesctription=?, quatntity=?, supplier=?, taskId=? WHERE ressourceId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, resource.getRessourceName());
            statement.setString(2, resource.getRessourceDescription());
            statement.setInt(3, resource.getQuantity());
            statement.setString(4, resource.getSupplier());
            statement.setInt(5, resource.getIdTask());
            statement.setInt(6, resource.getRessourceId());
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
    public Ressources getResourceById(int resourceId) throws SQLException {
        String sql = "SELECT * FROM ressources WHERE ressourceId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, resourceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Ressources(
                            resultSet.getInt("resourceId"),
                            resultSet.getString("resourceName"),
                            resultSet.getString("resourceDescription"),
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
    public List<Ressources> getResourcesByTaskId(int taskId) throws SQLException {
        List<Ressources> resources = new ArrayList<>();
        String sql = "SELECT * FROM ressources WHERE taskId=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, taskId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    resources.add(new Ressources(
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
    public List<Ressources> getAllResources() throws SQLException {
        List<Ressources> resources = new ArrayList<>();
        String sql = "SELECT * FROM ressources";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                resources.add(new Ressources(
                        resultSet.getInt("resourceId"),
                        resultSet.getString("resourceName"),
                        resultSet.getString("resourceDescription"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("supplier"),
                        resultSet.getInt("idTask")
                ));
            }
        }
        return resources;
    }
}

