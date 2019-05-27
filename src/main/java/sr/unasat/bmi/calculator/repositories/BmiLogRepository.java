package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.BmiLog;
import sr.unasat.bmi.calculator.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        return Math.round(bmiFormule * 100.0) / 100.0 ;
    }

    public String checkBmiRange(double bmi){
        String bmiMessage = "";
        if(bmi < 18.5){
            bmiMessage =  "You are underweight";
        }
        if(bmi >= 18.5 && bmi <= 24.9){
            bmiMessage =  "You are healthy";
        }
        if(bmi >= 25 && bmi <= 29.9){
            bmiMessage = "You bent overweight";
        }
        if(bmi >= 30){
            bmiMessage = "You are obese";
        }
        return bmiMessage;
    }

    public List<BmiLog> getAllBmiLogByUserId(int id){
        List<BmiLog> logList = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "select * from bmi_logs where user_id = ? ORDER BY date desc LIMIT 10" ;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                logList.add(new BmiLog(rs.getInt("id"), rs.getInt("user_id"),rs.getDouble("bmi"),rs.getDouble("weight"),rs.getString("date"))
                );
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logList;
    }


    public BmiLog getSingleBmiLogByUserId(int id){
        BmiLog log = null;
        PreparedStatement stmt;
        String sql = "SELECT * FROM bmi_logs WHERE user_id = ? ORDER BY date DESC LIMIT 1";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                System.out.println("No user with given info");
            }else{
                rs.next();
                log = new BmiLog(rs.getInt("id"), rs.getInt("user_id"),rs.getDouble("bmi"),rs.getDouble("weight"),rs.getString("date"));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return log;

    }
}


