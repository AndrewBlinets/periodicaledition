package by.andreiblinets.dao;

import by.andreiblinets.dto.UserDTO;
import by.andreiblinets.entity.User;

public interface UserDAO {
    UserDTO checkAutification(String login, String password);
    void addUser(User user);
}
