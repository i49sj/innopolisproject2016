package ru.innopolis.studentproject.server.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by User on 31.10.2016.
 */
public class DBConnection {

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        return MySQLConnection.getMySQLConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}
