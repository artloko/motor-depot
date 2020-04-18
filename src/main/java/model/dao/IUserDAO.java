package model.dao;

import model.entity.User;
import model.exception.DAOException;


public interface IUserDAO {
    User getUserInfo(String login, String password) throws DAOException;

    void registerUser(User user) throws DAOException;
}
