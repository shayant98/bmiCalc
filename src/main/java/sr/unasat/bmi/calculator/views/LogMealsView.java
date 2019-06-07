package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class LogMealsView {
    private User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console

    public LogMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showLogMealsView(){
//        TODO: Show all mealplans
//        TODO: Get input from user (INT)
//        TODO: Ask user if they're sure
//        TODO: After comfirm insert into DB (TRY CATCH)
            Helper helper = new Helper();
            helper.returnToMenu(loggedInUser);



    }
}

