package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;

import java.util.Scanner;

public class logMealsView {

    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console

    public logMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showLogMealsViewScreen(){
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        mealPlanRepository.GetAllMealplans().forEach(mealPlan -> {
            System.out.println("[ID]: "+ mealPlan.getId() +"   "+"[NAME]: "+ mealPlan.getName());
        });
        System.out.println("ID of meal to log:");
        //TODO: Validate userinput
        int mealId = userInput.nextInt();

    }
}
