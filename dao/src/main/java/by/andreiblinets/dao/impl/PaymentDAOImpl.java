package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.PaymentDAO;
import by.andreiblinets.entity.Payment;
import by.andreiblinets.util.ConnectionPool;
import by.andreiblinets.util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {

    public void addPayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           // connection = ConnectionPool.getConnector();
            preparedStatement = connection
                    .prepareStatement(Constants.SQL_QUERY_ADD_PAYMENT);
            preparedStatement.setString(1, String.valueOf(payment.getIdUser()));
            preparedStatement.setString(2, String.valueOf(payment.getSumma()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add payment");
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
                System.out.println("SQL exception occurred during add payment");
                //e.printStackTrace();
            }
        }
    }
}
