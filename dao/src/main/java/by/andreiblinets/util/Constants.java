package by.andreiblinets.util;

public class Constants {
    public static final String SQL_QUERY_ADD_PAYMENT = "INSERT INTO createpayment (iduser,kol) VALUES (?,?)";

    public static final String SQL_QUERY_ADD_PERIODICALEDITION = "INSERT periodicaleditiontable createpayment (name,price) VALUES (?,?)";
    public static final String SQL_QUERY_GET_PERIODICALEDITION = "SELECT * FROM periodicaleditiontable";

    public static final String SQL_QUERY_ADD_SUBSCRIPTION = "INSERT periodicaleditiontable createpayment (iduser,idperiodicaleditio) VALUES (?,?)";


    public static final String SQL_QUERY_CREATE_USER = "INSERT INTO user (login, password, name, userrol) VALUES (?,?,?,?)";
    public static final String SQL_QUERY_GET_USER = "SELECT id, name, userrol FROM user WHERE login = ? AND password = ?";
    public static final String SQL_QUERY_GET_ALL_USER = "SELECT id, name, userrol FROM user ";
    public static final String SQL_QUERY_GET_BY_ID_USER = "SELECT * FROM users WHERE id = ?";
    public static final String SQL_QUERY_DELETE_BY_ID_USER = "DELETE FROM users WHERE id = ?";

}
