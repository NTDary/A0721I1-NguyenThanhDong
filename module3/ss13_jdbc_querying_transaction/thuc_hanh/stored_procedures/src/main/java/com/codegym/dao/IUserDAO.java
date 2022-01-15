package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);
    public List<User> selectUserByCountry(String country);

    public List<User> selectAllUsers();
    public List<User> sortUserNameASC();
    public List<User> sortUserNameDESC();

    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;

    User getUserById(int id);
    void insertUserStore(User user) throws SQLException;

}
