package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.MealPlan;
import sr.unasat.bmi.calculator.services.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealPlanRepository {
    Connection connection;
    public MealPlanRepository() {
        Database database = new Database();
        connection = database.getDBConnection();
    }

    public List<MealPlan> GetAllMealplans(){
        List<MealPlan> mealPlanList = new ArrayList<>();
        Statement stmt = null;
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
        finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
            try {
                if(connection != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
        }
        return mealPlanList;
    }

    public void deleteMealplanById(int mealId){
        String sql = "DELETE FROM meal_plans WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, mealId);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
            try {
                if(connection != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
        }
    }

    public MealPlan findMealplanByid(int mealId){
        MealPlan mealPlan = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM meal_plans WHERE id = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,mealId);
            ResultSet rs = stmt.executeQuery();
            if(!rs.isBeforeFirst()){
                return null;
            }else{
                rs.next();
                mealPlan = new MealPlan(rs.getInt("id"),rs.getString("name"),rs.getInt("type"),rs.getInt("calorie"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
            try {
                if(connection != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
        }
        return mealPlan;
    }

    public void updateMealById(MealPlan updatedMealPlan){
        String sql = "UPDATE meal_plans SET name = ?, type = ?,calorie = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, updatedMealPlan.getName());
            stmt.setInt(2, updatedMealPlan.getType());
            stmt.setInt(3, updatedMealPlan.getCalorie());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
            try {
                if(connection != null){
                    stmt.close();
                }
            }catch (SQLException e){

            }
        }
    }
}
