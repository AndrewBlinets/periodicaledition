package by.andreiblinets.dao.dao.impl;

import by.andreiblinets.dao.dao.BaseDAO;
import by.andreiblinets.dao.entity.Payment;
import by.andreiblinets.dao.util.Constants;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.andreiblinets.dao.util.DaoUtils.closePreparedStatement;
import static by.andreiblinets.dao.util.DaoUtils.closeResultSet;

public class PaymentDAOImpl extends BaseDAO<Payment> {


    private static Logger logger = Logger.getLogger(PaymentDAOImpl.class.getName());

    private static PaymentDAOImpl instance;

    private PaymentDAOImpl() {
        super();
    }

    public synchronized static PaymentDAOImpl getInstance() {
        if (instance == null) {
            instance = new PaymentDAOImpl();
        }
        return instance;
    }

    public Long create(Payment payment) {
        Long createId = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_CREATE_PAYMENT);
            preparedStatement.setString(1, String.valueOf(payment.getIdUser()));
            preparedStatement.setString(2, String.valueOf(payment.getSumma()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                createId = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("Payment not add is system");
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return createId;
    }

    public void update(Payment payment) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_UPDATE_PAYMENT);
            preparedStatement.setString(1, String.valueOf(payment.getIdUser()));
            preparedStatement.setString(2, String.valueOf(payment.getSumma()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in PaymentDAOImpl update()" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public List<Payment> readAll() {
        ResultSet resultSet = null;
        List<Payment> payments = new ArrayList<Payment>();
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_ALL_PAYMENT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payment;
                payment = getObjectUserPayment(resultSet);
                payments.add(payment);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in PaymentDAOImpl readAll()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return payments;
    }

    public Payment readById(Long id) {
        ResultSet resultSet = null;
        Payment payment = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_BY_ID_PAYMENT);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                payment = getObjectUserPayment(resultSet);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in PaymentDAOImpl readById()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return payment;
    }

    public void delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_DELETE_PAYMENT);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in PaymentDAOImpl delete(id)" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private Payment getObjectUserPayment(ResultSet resultSet) throws SQLException {
        Payment payment = new Payment();
        payment.setId(resultSet.getInt(1));
        payment.setIdUser(resultSet.getInt(2));
        payment.setSumma(resultSet.getInt(3));
        return payment;
    }
}
