package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealLogRepository;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.sql.SQLException;
import java.util.Scanner;

public class LogMealsView {

    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console
    Helper helper = new Helper();
    public LogMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showLogMealsScreen(){
        boolean mealIdIsNumber = false;
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        mealPlanRepository.getAllMealplans().forEach(mealPlan -> {
            System.out.println("[ID]: "+ mealPlan.getId() +"   "+"[NAME]: "+ mealPlan.getName());
        });
        System.out.println("ID of meal to log:");
        do {
            if(userInput.hasNextInt()){
                int mealId = userInput.nextInt();
                MealLogRepository mealLogRepository = new MealLogRepository();
                try {
                    mealLogRepository.InsertNewMealLog(loggedInUser.getId(), mealId);
                }catch (SQLException e){
                    e.printStackTrace();
                }
                mealIdIsNumber = false;

                helper.returnToMenu(loggedInUser);
            }else{
                helper.errorMessage();
                mealIdIsNumber = false;
                userInput.next();
            }
        }while (!mealIdIsNumber);
    }
}
