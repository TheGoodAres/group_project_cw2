package com.mycompany.group_project_cw2;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
public class CreateDatabase {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connect connect = new Connect();
    }
}

class Connect {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection con;

    public Connect() {
        urlSQLite = "jdbc:sqlite:language_app.db";

        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (SQLException e) {
            System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(urlSQLite);// create database if it does not exist.
            System.out.println("Connection to SQLite is done.");
        } catch (SQLException e) {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }

        try {
            if (!con.isClosed()) {
                con.close();
                System.out.println("Connection to SQLite closed.");
            }
        } catch (SQLException e) {
            System.out.println("Problem with close connection of SQLite");
        }
    }
}
