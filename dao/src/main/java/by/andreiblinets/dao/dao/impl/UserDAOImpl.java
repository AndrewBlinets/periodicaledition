package by.andreiblinets.dao.dao.impl;

import by.andreiblinets.dao.dao.BaseDAO;
import by.andreiblinets.dao.dao.IUserDAO;
import by.andreiblinets.dao.entity.User;
import by.andreiblinets.dao.entity.enums.UserRole;
import by.andreiblinets.dao.util.Coder;
import by.andreiblinets.dao.util.Constants;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.andreiblinets.dao.util.DaoUtils.closePreparedStatement;
import static by.andreiblinets.dao.util.DaoUtils.closeResultSet;


public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {

    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    private static UserDAOImpl instance;

    private UserDAOImpl() {
        super();
    }

    public synchronized static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    public Long create(User user) {
        Long createId = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_CREATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, Coder.getHashCode(user.getPassword()));
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getUserRole().toString());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                createId = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("User not add is system");
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return createId;
    }

    public void update(User user) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_UPDATE_BY_ID_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, String.valueOf(user.getUserRole()));
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, Coder.getHashCode(user.getPassword()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl update()" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public List<User> readAll() {
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_ALL_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user;
                user = getObjectUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl readAll()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return users;
    }

    public User readById(Long id) {
        ResultSet resultSet = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_BY_ID_USER);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getObjectUser(resultSet);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl readById()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return user;
    }

    public void delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_DELETE_BY_ID_USER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl delete(id)" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public User getUser(String login, String password) {
        User user = null;
        String passwordHash = Coder.getHashCode(password);
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordHash);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = getObjectUser(resultSet);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in getUser(login, password)" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return user;
    }

    private User getObjectUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setUserRole(UserRole.valueOf(resultSet.getString(3)));
        return user;
    }
}
