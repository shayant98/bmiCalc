package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.services.Helper;

public class ViewMeals {
    User loggedInUser;

    public ViewMeals(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showViewMealsScreen(){
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        System.out.println("ID | Name | Category | Calorie Count");
        mealPlanRepository.getAllMealPlans().forEach(mealPlan -> {
//            System.out.println(mealPlan);
            System.out.println(mealPlan.getId() + " | " + mealPlan.getName() + " | " + mealPlan.getTypeName()+ " | " + mealPlan.getCalorie());
        });
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
