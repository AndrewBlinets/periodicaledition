package by.andreiblinets.dao.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtils {

    private static Logger logger = Logger.getLogger(DaoUtils.class.getName());

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.debug("resultSet is null" + e);
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.debug("preparedStatement is null" + e);
            }
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.debug("connection is null" + e);
            }
        }
    }
}
