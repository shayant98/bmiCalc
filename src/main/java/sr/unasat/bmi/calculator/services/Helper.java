package sr.unasat.bmi.calculator.services;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.views.Menu;

import java.util.Scanner;

public class Helper {
    private User loggedInUser;
    Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren

    public Helper(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void returnToMenu(){
        Menu menu = new Menu(loggedInUser);
        System.out.println("Press 'r' to return to menu");
        while (true){ //infinte loop
            if(userInput.next().equals("r")){
                menu.showMenu();
                break;
            }else{
                System.out.println("Not R");
            }
        }
    }
}
