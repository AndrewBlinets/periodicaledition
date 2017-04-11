package by.andreiblinets.dao;


import by.andreiblinets.entity.User;

public interface IUserDAO {
    User getUser(String login, String password);
}
