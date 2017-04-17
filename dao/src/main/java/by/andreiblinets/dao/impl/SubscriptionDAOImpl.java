package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.BaseDAO;
import by.andreiblinets.entity.Subscription;
import by.andreiblinets.util.Constants;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.andreiblinets.util.DaoUtils.closePreparedStatement;
import static by.andreiblinets.util.DaoUtils.closeResultSet;

public class SubscriptionDAOImpl extends BaseDAO<Subscription>  {

    private static Logger logger = Logger.getLogger(SubscriptionDAOImpl.class.getName());

    private static SubscriptionDAOImpl instance;

    private SubscriptionDAOImpl() {
        super();
    }

    public synchronized static SubscriptionDAOImpl getInstance() {
        if (instance == null) {
            instance = new SubscriptionDAOImpl();
        }
        return instance;
    }

    public Long create(Subscription subscription) {
        Long createId = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_CREATE_SUBSCRIPTION);
            preparedStatement.setString(1, String.valueOf(subscription.getIdUser()));
            preparedStatement.setString(2, String.valueOf(subscription.getIdPeriodicalEdition()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                createId = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("Subscription not add for subscription");
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return createId;
    }

    public void update(Subscription subscription) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_UPDATE_BY_ID_SUBSCRIPTION);
            preparedStatement.setString(1, String.valueOf(subscription.getIdUser()));
            preparedStatement.setString(2, String.valueOf(subscription.getIdPeriodicalEdition()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in SubscriptionDAOImpl update()" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public List<Subscription> readAll() {
        ResultSet resultSet = null;
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_ALL_SUBSCRIPTION);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Subscription subscription;
                subscription = getObjectSubscription(resultSet);
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl readAll()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return subscriptions;
    }

    public Subscription readById(Long id) {
        ResultSet resultSet = null;
        Subscription subscription = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_BY_ID_SUBSCRIPTION);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subscription = getObjectSubscription(resultSet);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in UserDAOImpl readById()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return subscription;
    }

    private Subscription getObjectSubscription(ResultSet resultSet) throws SQLException {
        Subscription subscription = new Subscription();
        subscription.setId(resultSet.getInt(1));
        subscription.setIdPeriodicalEdition(resultSet.getInt(2));
        subscription.setIdUser(resultSet.getInt(3));
        return subscription;
    }

    public void delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_DELETE_BY_ID_SUBSCRIPTION);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in SubscriptionDAOImpl delete(id)" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }
}
