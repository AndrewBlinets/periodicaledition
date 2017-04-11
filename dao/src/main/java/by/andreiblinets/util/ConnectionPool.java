package by.andreiblinets.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static ConnectionPool instance;
    private static BasicDataSource dataSource = new BasicDataSource();
    private static final ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

    public ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        dataSource.setDriverClassName(resourceBundle.getString("db.driver"));
        dataSource.setUsername(resourceBundle.getString("db.user"));
        dataSource.setPassword(resourceBundle.getString("db.password"));
        dataSource.setUrl(resourceBundle.getString("db.url"));
    }

    public Connection getConnection() throws SQLException {

        if (threadConnection.get() == null) {
            Connection connection = dataSource.getConnection();
            threadConnection.set(connection);
            return threadConnection.get();
        } else
            return threadConnection.get();
    }

    public synchronized static ConnectionPool getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance == null) {
            instance = new ConnectionPool();
            return instance;
        } else {
            return instance;
        }
    }
}
