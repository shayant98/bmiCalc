package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.services.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mealTypeRepository {
    Connection connection;
    public mealTypeRepository() {
        Database database = new Database();
        connection = database.getDBConnection();
    }


    public String getMealType(int typeId){
        String mealType = "";
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM meal_types WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,typeId);

            ResultSet rs = stmt.executeQuery();
            if(!rs.isBeforeFirst()){
                System.out.println("No meal types to view!");
            }else{
                rs.next();
                mealType = rs.getString("name");
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
                    connection.close();
                }
            }catch (SQLException e){

            }
        }
        return mealType;
    }
}
