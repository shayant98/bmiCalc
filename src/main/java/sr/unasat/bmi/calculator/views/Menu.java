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
             System.out.println("["+i+"]"+" "+ menuOptions[i]);

        }


        int chosenMenuOption = userInput.nextInt();
        String activeMenuOption = showMenuOption(chosenMenuOption);
        switch (activeMenuOption) {
            case "BMI Calculator":
                System.out.println("---------- BMI Calculator ----------");
                BmiCalculator bmiCalculator = new BmiCalculator(loggedInUser);
                bmiCalculator.showBmiCalculatorScreen();
                break;
            case "BMI History":
                System.out.println("---------- BMI History ----------");
                BmiHistory bmiHistory = new BmiHistory(loggedInUser);
                bmiHistory.showBmiHistoryScreen();
                break;
            case "Log Meals":
                System.out.println("---------- Log Meals ----------");
                break;
            case "View Meals":
                System.out.println("---------- View Meals ----------");
                ViewMeals viewMeals = new ViewMeals(loggedInUser);
                viewMeals.showViewMealsScreen();
                break;
            case "Update Meals":
                System.out.println("---------- Update Meals ----------");
                break;
            case "View user info":
                System.out.println("---------- View user info ----------");
                UserInfo userInfo = new UserInfo(loggedInUser);
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
