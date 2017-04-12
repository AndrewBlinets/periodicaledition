package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.BaseDAO;
import by.andreiblinets.entity.PeriodicalEdition;
import by.andreiblinets.util.Constants;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.andreiblinets.util.DaoUtils.closePreparedStatement;
import static by.andreiblinets.util.DaoUtils.closeResultSet;

public class IPeriodicalEditionDAOImpl extends BaseDAO<PeriodicalEdition> {

    private static Logger logger = Logger.getLogger(IUserDAOImpl.class.getName());

    private static IPeriodicalEditionDAOImpl instance;

    private IPeriodicalEditionDAOImpl() {
        super();
    }

    public synchronized static IPeriodicalEditionDAOImpl getInstance() {
        if (instance == null) {
            instance = new IPeriodicalEditionDAOImpl();
        }
        return instance;
    }

    public Long create(PeriodicalEdition periodicalEdition) {
        Long createId = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_CREATE_PERIODICALEDITION);
            preparedStatement.setString(1, periodicalEdition.getName());
            preparedStatement.setString(3, String.valueOf(periodicalEdition.getPrice()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                createId = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("Periodical Edition not add is system");
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return createId;
    }

    public void update(PeriodicalEdition periodicalEdition) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_UPDATE_BY_ID_PERIODICALEDITION);
            preparedStatement.setString(1, periodicalEdition.getName());
            preparedStatement.setString(2, String.valueOf(periodicalEdition.getPrice()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in IPeriodicalEditionDAOImpl update()" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public List<PeriodicalEdition> readAll() {
        ResultSet resultSet = null;
        List<PeriodicalEdition> periodicalEditions = new ArrayList<PeriodicalEdition>();
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_ALL_PERIODICALEDITION);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PeriodicalEdition periodicalEdition = new PeriodicalEdition();
                periodicalEdition = getObjectPeriodicalEdition(resultSet, periodicalEdition);
                periodicalEditions.add(periodicalEdition);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in IPeriodicalEditionDAOImpl readAll()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return periodicalEditions;
    }

    private PeriodicalEdition getObjectPeriodicalEdition(ResultSet resultSet, PeriodicalEdition periodicalEdition) throws SQLException {
        periodicalEdition.setName(resultSet.getString(1));
        periodicalEdition.setPrice(resultSet.getInt(2));;
        return periodicalEdition;
    }

    public PeriodicalEdition readById(Long id) {
        ResultSet resultSet = null;
        PeriodicalEdition periodicalEdition = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_GET_BY_ID_PERIODICALEDITION);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                periodicalEdition = new PeriodicalEdition();
                periodicalEdition = getObjectPeriodicalEdition(resultSet, periodicalEdition);
            }
        } catch (SQLException e) {
            logger.error("SQLException  in IPeriodicalEditionDAOImpl readById()" + e );
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return periodicalEdition;
    }

    public void delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_DELETE_BY_ID_PERIODICALEDITION);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException  in IPeriodicalEditionDAOImpl delete(id)" + e );
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }
}
