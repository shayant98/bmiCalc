package sr.unasat.bmi.calculator.repositories;

import sr.unasat.bmi.calculator.services.Database;

import java.sql.Connection;

public class MealLogRepository {
    Connection connection;
    public MealLogRepository() {

        Database database = new Database();
        connection = database.getDBConnection();
    }
}
