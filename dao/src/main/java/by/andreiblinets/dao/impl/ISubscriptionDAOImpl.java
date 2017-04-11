package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.ISubscriptionDAO;
import by.andreiblinets.entity.Subscription;
import by.andreiblinets.util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ISubscriptionDAOImpl implements ISubscriptionDAO {

    public void addSubscription(Subscription subscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           // connection = ConnectionPool.getConnector();
            preparedStatement = connection
                    .prepareStatement(Constants.SQL_QUERY_ADD_SUBSCRIPTION);
            preparedStatement.setString(1, String.valueOf(subscription.getIdUser()));
            preparedStatement.setString(2, String.valueOf(subscription.getIdPeriodicalEdition()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add SUBSCRIPTION");
            // e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL exception occurred during add SUBSCRIPTION");
                //e.printStackTrace();
            }
        }
    }
}
