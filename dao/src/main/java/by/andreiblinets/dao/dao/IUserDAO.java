package by.andreiblinets.dao.dao;


import by.andreiblinets.dao.entity.User;

public interface IUserDAO {
    User getUser(String login, String password);
    boolean getUserLogin(User user);
}
