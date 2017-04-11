package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.UserDAO;
import by.andreiblinets.entity.User;
import by.andreiblinets.entity.enums.UserRole;
import by.andreiblinets.util.ConnectionPool;
import by.andreiblinets.util.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAOImpl implements UserDAO {

    public User checkAutification(String login, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
           // connection = ConnectionPool.getConnector();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constants.SQL_QUERY_GET_USER);
            if (resultSet.next()) {
                user = getObjectUserDTO(resultSet);
            }
            else
                return null;
        }catch (SQLException e) {
            System.out.println("SQL exception");
            //e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL exception");
                //e.printStackTrace();
            }
        }
        return user;
    }

    private User getObjectUserDTO(ResultSet resultSet) throws SQLException {
        User userDTO = new User();
        userDTO.setId(resultSet.getInt(1));
        userDTO.setName(resultSet.getString(2));
        userDTO.setUserRole(UserRole.valueOf(resultSet.getString(3)));
        return userDTO;
    }
}
