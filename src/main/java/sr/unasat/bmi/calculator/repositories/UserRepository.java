package sr.unasat.bmi.calculator.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserRepository {
    private Connection connection;
    public UserRepository() {
        try {

            String URL = "jdbc:mysql://"+System.getenv("HOST")+":"+System.getenv("PORT")+"/bmi_calc";
            String USER = System.getenv("USERNAME");
            String PASS = System.getenv("PASSWORD");

            connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println(connection);
            System.out.println();


        }catch (SQLException execption){
            execption.printStackTrace();
        }
    }
}