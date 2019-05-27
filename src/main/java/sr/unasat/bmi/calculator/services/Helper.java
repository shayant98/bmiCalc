package sr.unasat.bmi.calculator.services;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.views.Menu;

import java.util.Scanner;

public class Helper {
    Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren


    public void returnToMenu(User loggedInUser){
        Menu menu = new Menu(loggedInUser);
        for (int i  = 0; i <3; i++){
            System.out.println("");
        }
        System.out.println("Press 'R' to return to menu");
        while (true){ //infinte loop
            String returnKey = userInput.next();
            if(returnKey.toUpperCase().equals("R")){
                menu.showMenu();
                break;
            }else{
                errorMessage("Key not recognised");
            }
        }
    }

    public void errorMessage(String Message){
        System.out.println("--------------------------------");
        System.out.println("|--XX--"+Message+"--XX--|");
        System.out.println("--------------------------------");
        System.out.println("Please try again!");
    }
}
