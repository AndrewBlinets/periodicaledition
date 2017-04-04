package by.andreiblinets.dao;

import by.andreiblinets.entity.Payment;
import by.andreiblinets.utils.ConnectorDB;
import by.andreiblinets.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAOImp implements PaymentDAO{

    public void addPayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectorDB.getConnector();
            preparedStatement = connection
                    .prepareStatement(Constants.SQL_QUERY_ADD_Payment);
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
