package by.andreiblinets.dao;


import by.andreiblinets.entity.User;

public interface UserDAO {
    User checkAutification(String login, String password);
}
