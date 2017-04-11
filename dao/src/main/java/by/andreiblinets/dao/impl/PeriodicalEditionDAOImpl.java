package by.andreiblinets.dao.impl;

import by.andreiblinets.dao.PeriodicalEditionDAO;
import by.andreiblinets.entity.PeriodicalEdition;
import by.andreiblinets.util.ConnectionPool;
import by.andreiblinets.util.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalEditionDAOImpl implements PeriodicalEditionDAO {

    public void addPeridicalEdition(PeriodicalEdition periodicalEdition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           // connection = ConnectionPool.getConnector();
            preparedStatement = connection
                    .prepareStatement(Constants.SQL_QUERY_ADD_PERIODICALEDITION);
            preparedStatement.setString(1, periodicalEdition.getName());
            preparedStatement.setString(2, String.valueOf(periodicalEdition.getPrice()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add Peridical Edition");
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
                System.out.println("SQL exception occurred during add Peridical Edition");
                //e.printStackTrace();
            }
        }
    }

    public List<PeriodicalEdition> getAllPeridicalEdition() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<PeriodicalEdition> periodicalEditions = null;
        try {
          //  connection = ConnectionPool.getConnector();
            statement = connection.createStatement();
            periodicalEditions = parserRequest(statement.executeQuery(Constants.SQL_QUERY_GET_PERIODICALEDITION));
        }catch (SQLException e) {
            System.out.println("SQL exception");
            //e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL exception");
                //e.printStackTrace();
            }
        }
        return periodicalEditions;
    }

    private List<PeriodicalEdition> parserRequest(ResultSet resultSet) throws SQLException {
        List<PeriodicalEdition> clients = new ArrayList<PeriodicalEdition>();
        while (resultSet.next()) {
            PeriodicalEdition periodicalEdition = new PeriodicalEdition();
            periodicalEdition.setId(resultSet.getInt(1));
            periodicalEdition.setName(resultSet.getString(2));
            periodicalEdition.setPrice(resultSet.getInt(3));
            clients.add(periodicalEdition);
        }
        return clients;
    }

}
