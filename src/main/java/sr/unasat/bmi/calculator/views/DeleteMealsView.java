package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.MealPlan;
import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class DeleteMealsView {
    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console
    Helper helper = new Helper();
    public DeleteMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showDeleteMealsScreen(){
        boolean mealIdIsNumber = false;
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        if(mealPlanRepository.getAllMealplans() == null){
            helper.errorMessage("No meals found!");
            helper.returnToMenu(loggedInUser);
        }else{
            mealPlanRepository.getAllMealplans().forEach(mealPlan -> {
                System.out.println("[ID]: "+ mealPlan.getId() +"   "+"[NAME]: "+ mealPlan.getName());
            });
        }
        System.out.println("ID of meal to delete or press 'R' to cancel:");
        do {
            if (userInput.hasNextInt()){
                int mealId = userInput.nextInt();
                MealPlan mealExists = mealPlanRepository.findMealplanById(mealId);
                if (mealExists == null){
                    System.out.println("meal not found");
                    mealIdIsNumber = false;
                    continue; //restarts the loop
                }else{
                    System.out.println("deleting Meal...");
                    mealPlanRepository.deleteMealplanById(mealId);
                    helper.returnToMenu(loggedInUser);
                }
                mealIdIsNumber = true;
            }else if (helper.returnKeyPressed(userInput.next())) {
                helper.returnToMenu(loggedInUser);
            }
            else{
                helper.errorMessage();
                mealIdIsNumber = false;
                userInput.next();
            }
        }while (!mealIdIsNumber);


    }
}
