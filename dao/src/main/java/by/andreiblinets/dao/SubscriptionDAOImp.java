package by.andreiblinets.dao;

import by.andreiblinets.entity.Subscription;
import by.andreiblinets.utils.ConnectorDB;
import by.andreiblinets.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscriptionDAOImp implements SubscriptionDAO {

    public void addSubscription(Subscription subscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectorDB.getConnector();
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
