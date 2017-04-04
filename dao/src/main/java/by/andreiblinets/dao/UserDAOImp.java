package by.andreiblinets.dao;

import by.andreiblinets.dto.UserDTO;
import by.andreiblinets.utils.ConnectorDB;
import by.andreiblinets.utils.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAOImp implements UserDAO{

    public UserDTO checkAutification(String login, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UserDTO userDTO = null;
        try {
            connection = ConnectorDB.getConnector();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constants.SQL_QUERY_GET_USER);
            if (resultSet.next()) {
                userDTO = getObjectUserDTO(resultSet);
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
        return userDTO;
    }

    private UserDTO getObjectUserDTO(ResultSet resultSet) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(resultSet.getInt(1));
        userDTO.setName(resultSet.getString(2));
        userDTO.setRolesUser(resultSet.getString(3));
        return userDTO;
    }
}
