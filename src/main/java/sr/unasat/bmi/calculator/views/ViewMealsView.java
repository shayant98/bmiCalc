package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealPlanRepository;
import sr.unasat.bmi.calculator.repositories.mealTypeRepository;
import sr.unasat.bmi.calculator.services.Helper;

public class ViewMealsView {
    User loggedInUser;

    public ViewMealsView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public void showViewMealsScreen(){
        MealPlanRepository mealPlanRepository = new MealPlanRepository();
        System.out.println("ID | Name | Category | Calorie Count");
        mealPlanRepository.GetAllMealplans().forEach(mealPlan -> {
            mealTypeRepository mealTypeRepository = new mealTypeRepository();
            String mealType = mealTypeRepository.getMealType(mealPlan.getType());
            System.out.println(mealPlan.getId() + " | " + mealPlan.getName() + " | " + mealType + " | " + mealPlan.getCalorie());
        });
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
