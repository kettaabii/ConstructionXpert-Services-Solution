package implementation;

import DAO.UserDao;
import modals.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public Connection connection;
    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from users where username=? and password=?";
        Connection con = Connectiondb.getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 int id = rs.getInt("userId");
                 String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                String profile = rs.getString("profile");
                User user = new User(id,username1,password1,profile);
                return user;
            }

        }
        return null;
    }


}
