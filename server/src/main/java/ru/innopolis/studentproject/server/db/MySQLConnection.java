package ru.innopolis.studentproject.server.db;

/**
 * Created by User on 31.10.2016.
 */


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 30.10.2016.
 */
public class MySQLConnection {

    public static java.sql.Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "studentstorage";
        String userName = "root";
        String password = "Admin123";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static java.sql.Connection getMySQLConnection(String hostName, String dbName,
                                                         String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        //String connectionURL =  "jdbc:mysql://localhost/userstorage";
        String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
        java.sql.Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        System.out.println("Creating statement...");
        return conn;
    }
}
