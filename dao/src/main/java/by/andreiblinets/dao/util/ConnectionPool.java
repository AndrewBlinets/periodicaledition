package by.andreiblinets.dao.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static Logger logger = Logger.getLogger(Coder.class.getName());

    private static ConnectionPool instance;
    private static BasicDataSource dataSource = new BasicDataSource();

    public ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        dataSource.setDriverClassName(resourceBundle.getString("db.driver"));
        dataSource.setUsername(resourceBundle.getString("db.user"));
        dataSource.setPassword(resourceBundle.getString("db.password"));
        dataSource.setUrl(resourceBundle.getString("db.url"));
    }

    public synchronized static ConnectionPool getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance == null) {
            instance = new ConnectionPool();
            return instance;
        } else {
            return instance;
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection =  dataSource.getConnection();
        } catch (SQLException e) {
            logger.error(e);
        }
        return connection;
    }
}
