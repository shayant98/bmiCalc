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


    public void showUpdateMealsScreen(){
        boolean mealIdIsNumber = false;
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        mealPlanRepository.GetAllMealplans().forEach(mealPlan -> {
            System.out.println("[ID]: "+ mealPlan.getId() +"   "+"[NAME]: "+ mealPlan.getName());
        });
        System.out.println("ID of meal to update:");
        do {
            if (userInput.hasNextInt()){
                int mealId = userInput.nextInt();
                MealPlan mealToUpdate = mealPlanRepository.findMealplanByid(mealId);
                if (mealToUpdate == null){
                    System.out.println("meal not found");
                    mealIdIsNumber = false;
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
                    Helper helper = new Helper();
                    helper.returnToMenu(loggedInUser);
                }
            }else{
                userInput.next();
                mealIdIsNumber = false;
            }
        }while (!mealIdIsNumber);

    }


}
