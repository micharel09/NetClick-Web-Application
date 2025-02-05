/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUNGHUYNH
 */
public class DBUtils {
    

    public static Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName + "?useUnicode=true&amp;characterEncoding=UTF-8";
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (SQLException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        }
        return null;
    }
    private final static String serverName = "34.87.183.230";
    private final static String dbName = "netclick";
    private final static String portNumber = "1433";
    private final static String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final static String userID = "sqlserver";
    private final static String password = "12345";
}
