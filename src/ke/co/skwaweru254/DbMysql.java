package ke.co.skwaweru254;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMysql {

    //?autoReconnect=true&useSSL=false will disable ssl and suppress ssl
    private static final String connection = "jdbc:mysql://localhost:3306/dbMSpace?autoReconnect=true&useSSL=false";

    //the old com.mysql.jdbc.Driver class name was deprecated
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String user = "root";

    private static final String password = "Mspace54#";


    public static void main(String[] args) {
        mysqlConnect();
        closeConnection();

    }


    public static void mysqlConnect() {

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connection, user, password);
            System.out.println("Successfully connected to database: " + con + "\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't load driver.\n");
        } catch (SQLException e) {
            System.err.println("Couldn't connect to database.\n");
        }
    }

    public static void closeConnection() {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connection, user, password);
            if (!con.isClosed()) {
                con.close();
                System.out.println("Database closed successfully.\n");
            }
        } catch (NullPointerException e) {
            System.err.println("Couldn't load driver.\n");
        } catch (SQLException e) {
            System.err.println("Couldn't close database.\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't load class.\n");
            throw new RuntimeException(e);

        }
    }


}
