package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class Menu {
    private Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren
    private String[] menuOptions = {
            "BMI Calculator",
            "BMI History",
            "Log Meals",
            "Update Meal Log",
            "Delete Meal Log",
            "View Meals",
            "Delete Meals",
            "Update Meals",
            "View user info",
    };
    private User loggedInUser;

    public Menu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    Helper helper = new Helper();
    public void showMenu(){
        System.out.println("---------- Menu ----------");
        boolean isNumber = false;
        //Show all menu items
        for (int i = 0; i < menuOptions.length; i++) {
             System.out.println("[ID]: "+ i +" - "+ menuOptions[i]);

        }
        System.out.println("");
        System.out.println("Please insert menu ID:");
        do {
            if(userInput.hasNextInt()){
                int chosenMenuOption = userInput.nextInt();
                String activeMenuOption = showMenuOption(chosenMenuOption);
                switch (activeMenuOption) {
                    case "BMI Calculator":
                        System.out.println("---------- BMI Calculator ----------");
                        BmiCalculatorView bmiCalculator = new BmiCalculatorView(loggedInUser);
                        bmiCalculator.showBmiCalculatorScreen();
                        break;
                    case "BMI History":
                        System.out.println("---------- BMI History ----------");
                        BmiHistoryView bmiHistory = new BmiHistoryView(loggedInUser);
                        bmiHistory.showBmiHistoryScreen();
                        break;
                    case "Log Meals":
                        System.out.println("---------- Log Meals ----------");
                        LogMealsView logMealsView = new LogMealsView(loggedInUser);
                        logMealsView.showLogMealsScreen();
                        break;
                    case "Update Meal Log":
                        System.out.println("---------- Update Meal Log ----------");
                        UpdateMealsLogView updateMealsLogView = new UpdateMealsLogView(loggedInUser);
                        updateMealsLogView.showUpdateMealsLogScreen();
                        break;case "Delete Meal Log":
                        System.out.println("---------- Update Meal Log ----------");
                        DeleteMealsLogView deleteMealsLogView = new DeleteMealsLogView(loggedInUser);
                        deleteMealsLogView.showDeleteMealsLogScreen();
                        break;
                    case "View Meals":
                        System.out.println("---------- View Meals ----------");
                        ViewMealsView viewMeals = new ViewMealsView(loggedInUser);
                        viewMeals.showViewMealsScreen();
                        break;
                    case "Update Meals":
                        System.out.println("---------- Update Meals ----------");
                        UpdateMealsView updateMealsView = new UpdateMealsView(loggedInUser);
                        updateMealsView.showUpdateMealsScreen();
                        break;
                    case "Delete Meals":
                        System.out.println("---------- Delete Meals ----------");
                        DeleteMealsView deleteMealsView = new DeleteMealsView(loggedInUser);
                        deleteMealsView.showDeleteMealsScreen();
                        break;
                    case "View user info":
                        System.out.println("---------- View user info ----------");
                        UserInfoView userInfo = new UserInfoView(loggedInUser);
                        userInfo.showUserInfoScreen();
                        break;
                    default:
                        System.out.println(activeMenuOption);
                }
                isNumber = true;
            }else{
                helper.errorMessage();
                isNumber = false;
                userInput.next();
            }
        }while (!isNumber);


    }

    private String showMenuOption(int menuItem){
        return menuOptions[menuItem];
    }


}
