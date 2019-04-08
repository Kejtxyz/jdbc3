package JdbcExample3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcMain {

    public static final String SQL = "delete from zawodnicy where imie=? and nazwisko=?";
    public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";
    public static final String USER = "klient";
    public static final String PASSWORD = "123";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preapredStatement = connection.prepareStatement(SQL);
            preapredStatement.setString(1,"Kasia");
            preapredStatement.setString(2,"Mailinowska");
            preapredStatement.addBatch();

            preapredStatement.setString(1,"Piotr");
            preapredStatement.setString(2,"MALYSZ");
            preapredStatement.addBatch();
            int[] executeBatch = preapredStatement.executeBatch();

            for (int i:executeBatch){
                System.out.println(i);
            }
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
