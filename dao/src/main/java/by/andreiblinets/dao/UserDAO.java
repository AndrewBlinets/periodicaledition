package by.andreiblinets.dao;

import by.andreiblinets.dto.UserDTO;

public interface UserDAO {
    UserDTO checkAutification(String login, String password);
}
