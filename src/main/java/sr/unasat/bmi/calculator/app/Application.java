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

//        APP NAME
        System.out.println("\n" +
                "  ____                _      _____           _                  _           _                  \n" +
                " |  _ \\              (_)    / ____|         | |                | |         | |                 \n" +
                " | |_) |  _ __ ___    _    | |        __ _  | |   ___   _   _  | |   __ _  | |_    ___    _ __ \n" +
                " |  _ <  | '_ ` _ \\  | |   | |       / _` | | |  / __| | | | | | |  / _` | | __|  / _ \\  | '__|\n" +
                " | |_) | | | | | | | | |   | |____  | (_| | | | | (__  | |_| | | | | (_| | | |_  | (_) | | |   \n" +
                " |____/  |_| |_| |_| |_|    \\_____|  \\__,_| |_|  \\___|  \\__,_| |_|  \\__,_|  \\__|  \\___/  |_|   \n" +
                "                                                                                               \n" +
                "                                                                                               \n");


        System.out.println("[USERNAME]: ");
        username = userInput.next(); //returns string
        System.out.println("PASSWORD: ");
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
