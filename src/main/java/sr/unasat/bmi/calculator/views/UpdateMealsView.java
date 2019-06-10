package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.MealPlan;
import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class UpdateMealsView {
    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console

    public UpdateMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    Helper helper = new Helper();

    public void showUpdateMealsScreen(){
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
        System.out.println("ID of meal to update:");
        do {
            if (userInput.hasNextInt()){
                int mealId = userInput.nextInt();
                MealPlan mealToUpdate = mealPlanRepository.findMealplanById(mealId);
                if (mealToUpdate == null){
                    System.out.println("meal not found");
                    mealIdIsNumber = false;
                    helper.returnToMenu(loggedInUser);
                    continue;

                }else{
                    System.out.println("Meal Name: ");
                    mealToUpdate.setName(userInput.next());
                    System.out.println("Meal Type ID: ");
//                    TODO: Validate meal Type
                    userInput.nextLine(); //idk why but fixed the error
                    mealToUpdate.setType(userInput.nextInt());
                    System.out.println("Meal Calorie");
                    mealToUpdate.setCalorie(userInput.nextInt());


                    mealPlanRepository.updateMealById(mealToUpdate);

                    helper.returnToMenu(loggedInUser);
                }
            }else{
                helper.errorMessage();
                userInput.next();
                mealIdIsNumber = false;
            }
        }while (!mealIdIsNumber);

    }


}
