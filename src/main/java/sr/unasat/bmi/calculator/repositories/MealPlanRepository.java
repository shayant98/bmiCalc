package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.MealPlan;
import sr.unasat.bmi.calculator.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealPlanRepository {
    Connection connection;
    public MealPlanRepository() {
        Database database = new Database();
        connection = database.getDBConnection();
    }

    public List<MealPlan> getAllMealPlans(){
        List<MealPlan> mealPlanList = new ArrayList<>();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            String sql = "select * from meal_plans";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            if (!rs.isBeforeFirst() ) {
                System.out.println("No user with given info");
            }else {
                while (rs.next()) {
                    mealPlanList.add(new MealPlan(rs.getInt("id"), rs.getString("name"), rs.getInt("type"), rs.getInt("calorie")));
                }
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealPlanList;
    }
}
