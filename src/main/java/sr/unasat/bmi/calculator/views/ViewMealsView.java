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
        mealPlanRepository.getAllMealplans().forEach(mealPlan -> {
            mealTypeRepository mealTypeRepository = new mealTypeRepository();
            String mealType = mealTypeRepository.getMealType(mealPlan.getType());
            System.out.println(" [ID]: "+ mealPlan.getId() + " [NAME]: " + mealPlan.getName() + " [CATEGORY]: " + mealType + " [CALORIE COUNT]: " + mealPlan.getCalorie());
        });
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
