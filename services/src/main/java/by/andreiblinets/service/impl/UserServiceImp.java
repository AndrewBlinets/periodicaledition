package by.andreiblinets.service.impl;

import by.andreiblinets.dao.impl.UserDAOImpl;
import by.andreiblinets.entity.User;
import by.andreiblinets.service.IUserService;

import java.util.List;

public class UserServiceImp implements IUserService {

    private static UserServiceImp instance;
    private UserDAOImpl userDAO = UserDAOImpl.getInstance();

    public synchronized static UserServiceImp getInstance() {
        if (instance == null) {
            instance = new UserServiceImp();
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
}
