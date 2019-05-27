package sr.unasat.bmi.calculator.app;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.UserRepository;
import sr.unasat.bmi.calculator.services.Helper;
import sr.unasat.bmi.calculator.views.Menu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Scanner userInput = new Scanner(System.in); //to read user input from console
        String username;
        String password;


        System.out.println("Log in");
        System.out.println("Username: ");
        username = userInput.next(); //returns string
        System.out.println("Password: ");
        password = userInput.next(); //returns string
        boolean isLoggedIn = userRepository.login(username, password);
        if(isLoggedIn){
            User loggedInUser = userRepository.findUserByUsername(username);

            loggedInUser.setLoggedIn(true);
            Menu menu = new Menu(loggedInUser);
            menu.showMenu();
        }else{
            Helper helper = new Helper();
            helper.errorMessage("No user with given info");
        }
    }
}
