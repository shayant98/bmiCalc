package sr.unasat.bmi.calculator.repositories;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class BmiLogRepository {
    private Connection connection;
    public BmiLogRepository() {
        try {

            String URL = "jdbc:mysql://"+System.getenv("HOST")+":"+System.getenv("PORT")+"/bmi_calc";
            String USER = System.getenv("USERNAME");
            String PASS = System.getenv("PASSWORD");

            connection = DriverManager.getConnection(URL,USER,PASS);
        }catch (SQLException execption){
            execption.printStackTrace();
        }
    }


    public double calculateBMI(double height, int weight) {
       double bmiFormule = weight/Math.pow(height,2);
        return bmiFormule;
    }
}
