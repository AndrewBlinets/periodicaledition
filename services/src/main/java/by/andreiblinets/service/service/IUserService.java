package by.andreiblinets.service.service;

import by.andreiblinets.dao.entity.User;

import java.util.List;

public interface IUserService {
    Long add(User user);
    void update(User user);
    List<User> getAll();
    void delete(Long id);
    User getById(Long id);
    User autification(String login, String password);
}
