package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.BaseDAO;
import by.andreiblinets.entity.Payment;
import by.andreiblinets.util.Constants;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.andreiblinets.util.DaoUtils.closePreparedStatement;
import static by.andreiblinets.util.DaoUtils.closeResultSet;

public class IPaymentDAOImpl extends BaseDAO<Payment> {


    private static Logger logger = Logger.getLogger(IUserDAOImpl.class.getName());

    private static IPaymentDAOImpl instance;

    private IPaymentDAOImpl() {
        super();
    }

    public synchronized static IPaymentDAOImpl getInstance() {
        if (instance == null) {
            instance = new IPaymentDAOImpl();
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
            logger.error("SQLException  in IPaymentDAOImpl update()" + e );
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
                Payment payment = new Payment();
                payment = getObjectUserPayment(resultSet, payment);
                payments.add(payment);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in IPaymentDAOImpl readAll()" + e );
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
                payment = new Payment();
                payment = getObjectUserPayment(resultSet, payment);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in IPaymentDAOImpl readById()" + e );
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
            logger.error("SQLException  in IPaymentDAOImpl delete(id)" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private Payment getObjectUserPayment(ResultSet resultSet, Payment payment) throws SQLException {
        payment.setId(resultSet.getInt(1));
        payment.setIdUser(resultSet.getInt(2));
        payment.setSumma(resultSet.getInt(3));
        return payment;
    }
}
