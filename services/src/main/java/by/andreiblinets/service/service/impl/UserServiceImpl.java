package by.andreiblinets.service.service.impl;

import by.andreiblinets.dao.dao.impl.UserDAOImpl;
import by.andreiblinets.dao.entity.User;
import by.andreiblinets.service.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private static UserServiceImpl instance;
    private UserDAOImpl userDAO = UserDAOImpl.getInstance();

    public synchronized static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public Long add(User user) {
        return userDAO.create(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public List<User> getAll() {
        return userDAO.readAll();
    }

    public void delete(Long id) {
        userDAO.delete(id);
    }

    public User getById(Long id) {
        return userDAO.readById(id);
    }

    public User autification(String login, String password) {
        return userDAO.getUser(login,password);
    }

    public boolean chekLogin(User user) {
        return userDAO.getUserLogin(user);
    }
}
