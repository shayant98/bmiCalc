package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public List<User> findAllUsers() {
        List<User> UserList = new ArrayList<>();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            String sql = "select * from users";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                UserList.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("username"), rs.getString("name"), rs.getInt("height")));
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UserList;
    }
}
