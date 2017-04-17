package by.andreiblinets.dao.util;

public class Constants {
    public static final String SQL_QUERY_CREATE_PAYMENT = "INSERT INTO payment (iduser,kol) VALUES (?,?)";
    public static final String SQL_QUERY_GET_ALL_PAYMENT = "SELECT * FROM payment";
    public static final String SQL_QUERY_GET_BY_ID_PAYMENT = "SELECT * FROM payment WHERE id = ?";
    public static final String SQL_QUERY_UPDATE_PAYMENT = "UPDATE payment" +
            " SET 'iduser' = ?,  'kol' = ?  WHERE id = ?";
    public static final String SQL_QUERY_DELETE_PAYMENT = "DELETE FROM payment WHERE id = ?";

    public static final String SQL_QUERY_CREATE_PERIODICALEDITION = "INSERT periodicaleditiontable createpayment" +
                                                                    " (name,price) VALUES (?,?)";
    public static final String SQL_QUERY_GET_ALL_PERIODICALEDITION = "SELECT * FROM periodicaleditiontable";
    public static final String SQL_QUERY_GET_BY_ID_PERIODICALEDITION = "SELECT * FROM periodicaleditiontable WHERE id = ?";
    public static final String SQL_QUERY_UPDATE_BY_ID_PERIODICALEDITION = "UPDATE periodicaleditiontable" +
            " SET 'name' = ?,  'price' = ?  WHERE id = ?";
    public static final String SQL_QUERY_DELETE_BY_ID_PERIODICALEDITION = "DELETE FROM periodicaleditiontable WHERE id = ?";

    public static final String SQL_QUERY_CREATE_SUBSCRIPTION = "INSERT subscription createpayment" +
            " (iduser,idperiodicaleditio) VALUES (?,?)";
    public static final String SQL_QUERY_DELETE_BY_ID_SUBSCRIPTION = "DELETE FROM subscription WHERE id = ?";
    public static final String SQL_QUERY_GET_ALL_SUBSCRIPTION = "SELECT * FROM subscription ";
    public static final String SQL_QUERY_GET_BY_ID_SUBSCRIPTION = "SELECT * FROM subscription WHERE id = ?";
    public static final String SQL_QUERY_UPDATE_BY_ID_SUBSCRIPTION = "UPDATE subscription SET 'idUser' = ?," +
                                                                    " 'idperiodicaleditio' = ? WHERE id = ?";

    public static final String SQL_QUERY_CREATE_USER = "INSERT INTO user (login, password, name, userrol) VALUES (?,?,?,?)";
    public static final String SQL_QUERY_GET_USER = "SELECT id, name, userrol FROM user WHERE login = ? AND password = ?";
    public static final String SQL_QUERY_GET_ALL_USER = "SELECT id, name, userrol FROM user ";
    public static final String SQL_QUERY_GET_BY_ID_USER = "SELECT * FROM users WHERE id = ?";
    public static final String SQL_QUERY_DELETE_BY_ID_USER = "DELETE FROM users WHERE id = ?";
    public static final String SQL_QUERY_UPDATE_BY_ID_USER = "UPDATE users SET 'name' = ?, 'userrol' = ?," +
                                                            " 'login' = ?, 'password' = ?  WHERE id = ?";

}
