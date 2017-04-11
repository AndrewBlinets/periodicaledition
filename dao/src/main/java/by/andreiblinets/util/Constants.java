package by.andreiblinets.util;

public class Constants {
    public static final String SQL_QUERY_ADD_PAYMENT = "INSERT INTO createpayment (iduser,kol) VALUES (?,?)";

    public static final String SQL_QUERY_ADD_PERIODICALEDITION = "INSERT periodicaleditiontable createpayment (name,price) VALUES (?,?)";
    public static final String SQL_QUERY_GET_PERIODICALEDITION = "SELECT * FROM periodicaleditiontable";

    public static final String SQL_QUERY_ADD_SUBSCRIPTION = "INSERT periodicaleditiontable createpayment (iduser,idperiodicaleditio) VALUES (?,?)";

    public static final String SQL_QUERY_GET_USER = "SELECT id, name, userrol FROM user WHERE login = ? AND password = ?";

}
