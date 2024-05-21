package DAO;

import modals.User;

import java.sql.SQLException;

public interface UserDao {
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException;
}
