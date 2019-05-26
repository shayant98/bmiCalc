package sr.unasat.bmi.calculator.app;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.UserRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        //test db function
//       userRepository.findAllUsers().forEach(user -> System.out.println(user.getName()));
//        System.out.println(userRepository.findUserById(1).getName());


        Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren
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
            System.out.println("Please choose one:");
            System.out.println("[1] Calculate BMI");
            System.out.println("[2] Calculate BMI");
            System.out.println("[3] Calculate BMI");
            System.out.println("[4] Calculate BMI");
            System.out.println("[5] Calculate BMI");
            System.out.println("[6] Calculate BMI");
            System.out.println("[7] Calculate BMI");
            int chosenMenuOption = userInput.nextInt();
            if (chosenMenuOption == 1){
                System.out.println("BMI Calc");
            }
            if(chosenMenuOption == 2){
                System.out.println("other option");
            }
        }else{
            System.out.println("check given info");
        }
    }
}
