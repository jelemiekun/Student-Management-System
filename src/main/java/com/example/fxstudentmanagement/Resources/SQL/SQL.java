package com.example.fxstudentmanagement.Resources.SQL;

import java.sql.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;
public class SQL {
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String USER = "root";
    private static String PASS = "admin";
    private static Connection connection;
    private static Statement statement;
    private static String databaseName = "student_management_fx";
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();

            alertSetHeaderText = "Connected to database.";
            alertSetContentText = "Successfully connected to database.";
            //sqlAlert(false);
            setDatabaseAndTable();
        } catch (SQLException e) {
            alertSetHeaderText = "Can't connect to database.";
            alertSetContentText = e.getMessage();
            //sqlAlert(true);
        }
    }

    private static void setDatabaseAndTable() {
        try {
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + databaseName + ";";
            statement.execute(createDatabaseQuery);

            statement.execute("USE " + databaseName);

            String createTableQuery = "CREATE TABLE IF NOT EXISTS teacher_list (" +
                    "employee_id VARCHAR(20)," +
                    "first_name VARCHAR(50)," +
                    "middle_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "gender VARCHAR(20)," +
                    "age INT," +
                    "phone_number VARCHAR (15)," +
                    "birthday DATE," +
                    "grade_level_teaching INT," +
                    "department VARCHAR(50)" +
                    ");";
            statement.execute(createTableQuery);
        } catch (SQLException e) {
            alertSetHeaderText = "Error setting database and table.";
            alertSetContentText = e.getMessage();
            sqlAlert(true);
        }
    }
}
