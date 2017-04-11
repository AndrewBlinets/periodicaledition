package by.andreiblinets.dao;

import by.andreiblinets.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseDAO<T> implements IDAO<T> {

    private static Logger logger = Logger.getLogger(BaseDAO.class.getName());

    protected static Connection connection;
    protected PreparedStatement preparedStatement;

    protected BaseDAO() {
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (IOException e) {
            logger.error("IOException at BaseDAO");
        } catch (SQLException e) {
            logger.error("SQLException at BaseDAO");
        } catch (PropertyVetoException e) {
            logger.error("PropertyVetoException at BaseDAO");
        }
    }


}