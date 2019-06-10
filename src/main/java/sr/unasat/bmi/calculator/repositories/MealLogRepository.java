package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.services.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MealLogRepository {
    Connection connection;
    public MealLogRepository() {

        Database database = new Database();
        connection = database.getDBConnection();
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
                    stmt.close();
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
