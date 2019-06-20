package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.entities.MealLog;
import sr.unasat.bmi.calculator.services.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealLogRepository {
    Connection connection;
    public MealLogRepository() {

        Database database = new Database();
        connection = database.getDBConnection();
    }
    public List<MealLog> getAllMealLogs(int userId){
        List<MealLog> mealLogList = new ArrayList<>();
        PreparedStatement stmt = null;
        String sql = "select *, u.name as UserName, mp.name as mealName from meal_logs INNER JOIN users u on meal_logs.user_id = u.id INNER JOIN meal_plans mp on meal_logs.meal_id = mp.id " +
                "WHERE meal_logs.user_id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
               return null;
            }else {
                while (rs.next()) {
                    MealLog mealLog = new MealLog(rs.getInt("id"), rs.getInt("meal_id"),rs.getInt("user_id"));
                    mealLog.setMealName(rs.getString("mealName"));
                    mealLog.setUserName(rs.getString("UserName"));
                    mealLogList.add(mealLog);
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
        return mealLogList;
    }

    public MealLog findMealLogByid(int logId){
        MealLog mealLog = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM meal_logs WHERE id = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,logId);
            ResultSet rs = stmt.executeQuery();
            if(!rs.isBeforeFirst()){
                return null;
            }else{
                rs.next();
                mealLog = new MealLog(rs.getInt("id"),rs.getInt("meal_id"),rs.getInt("user_id"));
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
        return mealLog;
    }

    public void InsertNewMealLog(int user_id,int meal_id) throws SQLException {
        PreparedStatement stmt= null;
        String sql = "INSERT INTO meal_logs (user_id,meal_id,date) VALUES (?,?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,user_id);
            stmt.setInt(2,meal_id);
            stmt.setDate(3, getCurrentDate());

            stmt.executeUpdate();
        } catch (SQLException e){
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
                    connection.close();
                }
            }catch (SQLException e){

            }
        }
    }

    public void updateMealLogById(MealLog updatedMealLog){
        String sql = "UPDATE meal_logs SET user_id = ?, meal_id = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, updatedMealLog.getUserId());
            stmt.setInt(2, updatedMealLog.getMealId());
            stmt.setInt(3, updatedMealLog.getId());
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
                    connection.close();
                }
            }catch (SQLException e){

            }
        }
    }

    public void deleteMealLogById(int logId){
        String sql = "DELETE FROM meal_logs WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, logId);
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
                    connection.close();
                }
            }catch (SQLException e){

            }
        }
    }

            private static java.sql.Date getCurrentDate(){
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
