package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.MealLog;
import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.MealLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class DeleteMealsLogView {
    User loggedInUser;
    Scanner userInput = new Scanner(System.in); //to read user input from console

    public DeleteMealsLogView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    Helper helper = new Helper();

    public void showDeleteMealsLogScreen(){
        boolean logIdIsNumber = false;
        MealLogRepository mealLogRepository = new MealLogRepository();
        mealLogRepository.getAllMealLogs().forEach(mealLog -> {
            System.out.println("[ID]: "+ mealLog.getId() +"   "+"[USER]: "+ mealLog.getUserId()+"   "+"[MEAL]: "+ mealLog.getMealId());
        });
        System.out.println("ID of log to delete:");
        do {
            if (userInput.hasNextInt()){
                int logId = userInput.nextInt();
                MealLog logToUpdate = mealLogRepository.findMealLogByid(logId);
                if (logToUpdate == null){
                    System.out.println("log not found");
                    logIdIsNumber = false;
                    continue;
                }else{
                    System.out.println("deleting Meal...");
                    mealLogRepository.deleteMealLogById(logId);
                    helper.returnToMenu(loggedInUser);
                }
            }else{
                helper.errorMessage();
                userInput.next();
                logIdIsNumber = false;
            }
        }while (!logIdIsNumber);

    }

  
}
