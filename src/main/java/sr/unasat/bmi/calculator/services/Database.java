package sr.unasat.bmi.calculator.services;

import java.sql.*;

public class Database {

    public Connection getDBConnection(){
        Connection dbConnection = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {
            String URL = "jdbc:mysql://"+System.getenv("HOST")+":"+System.getenv("PORT")+"/bmi_calc";
            String USER = System.getenv("USERNAME");
            String PASS = System.getenv("PASSWORD");

            dbConnection  = DriverManager.getConnection(URL,USER,PASS);



        } catch (SQLException e) {

            System.out.println(e.getSQLState());


        }

        return dbConnection;
    }
}
