package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.MealPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealPlanRepository {
    Connection connection;
    public MealPlanRepository() {
        try {

            String URL = "jdbc:mysql://"+System.getenv("HOST")+":"+System.getenv("PORT")+"/bmi_calc";
            String USER = System.getenv("USERNAME");
            String PASS = System.getenv("PASSWORD");

             connection = DriverManager.getConnection(URL,USER,PASS);



        }catch (SQLException execption){
            execption.printStackTrace();
        }
    }

    public List<MealPlan> getAllMealPlans(){
        List<MealPlan> mealPlanList = new ArrayList<>();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            String sql = "select meal_plans.*, meal_types.name as typeName from meal_plans inner join meal_types on meal_plans.type = meal_types.id";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            if (!rs.isBeforeFirst() ) {
                System.out.println("No user with given info");
            }else {
                while (rs.next()) {
                    mealPlanList.add(new MealPlan(rs.getInt("id"), rs.getString("name"), rs.getInt("type"),rs.getString("typeName"), rs.getInt("calorie")));
                }
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealPlanList;
    }
}
