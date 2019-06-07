package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.MealPlan;
import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class DeleteMealsView {
    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console

    public DeleteMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showDeleteMealsScreen(){
        boolean mealIdIsNumber = false;
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        mealPlanRepository.GetAllMealplans().forEach(mealPlan -> {
            System.out.println("[ID]: "+ mealPlan.getId() +"   "+"[NAME]: "+ mealPlan.getName());
        });
        System.out.println("ID of meal to delete:");
        do {
            if (userInput.hasNextInt()){
                int mealId = userInput.nextInt();
                MealPlan mealExists = mealPlanRepository.findMealplanByid(mealId);
                if (mealExists == null){
                    System.out.println("meal not found");
                    mealIdIsNumber = false;
                    continue;
                }else{
                    System.out.println("deleting Meal...");
                    mealPlanRepository.deleteMealplanById(mealId);
                    Helper helper = new Helper();
                    helper.returnToMenu(loggedInUser);
                }
                mealIdIsNumber = true;
            }
            else{
                System.out.println("Key not recognised");
                mealIdIsNumber = false;
                userInput.next();
            }
        }while (!mealIdIsNumber);


    }
}
