package ke.co.skwaweru254;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMysql {



    public static void main(String[] args){
        mysqlConnect();

    }


    public static void mysqlConnect() {

        //the old com.mysql.jdbc.Driver class name was deprecated
        String driver = "com.mysql.cj.jdbc.Driver";

        //?autoReconnect=true&useSSL=false will disable ssl and suppress ssl
        String connection = "jdbc:mysql://localhost:3306/dbMSpace?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "Mspace54#";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connection, user, password);
            System.out.println("Successfully connected to database: " +con);
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't load driver.");
        } catch (SQLException e) {
            System.err.println("Couldn't connect to database.");
        }
    }



}
