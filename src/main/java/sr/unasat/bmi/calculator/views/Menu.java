package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;

import java.util.Scanner;

public class Menu {
    private Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren
    private String[] menuOptions = {
            "BMI Calculator",
            "BMI History",
            "Log Meals",
            "View Meals",
            "Delete Meals",
            "Update Meals",
            "View user info",
    };
    private User loggedInUser;

    public Menu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showMenu(){
        System.out.println("---------- Menu ----------");

        //Show all menu items
        for (int i = 0; i < menuOptions.length; i++) {
             System.out.println("[ID]: "+ i +" - "+ menuOptions[i]);

        }
        System.out.println("");
        System.out.println("Please insert menu ID:");
//       TODO: Validate Userinput
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

    }

    private String showMenuOption(int menuItem){
        return menuOptions[menuItem];
    }


}
