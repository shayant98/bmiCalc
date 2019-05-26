package sr.unasat.bmi.calculator.app;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.BmiLogRepository;
import sr.unasat.bmi.calculator.repositories.MenuRepository;
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
            loggedInUser.setLoggedIn(true);
            MenuRepository menuRepository = new MenuRepository(loggedInUser.isLoggedIn());
            System.out.println("---------- Menu ----------");
            for (int i = 0; i < menuRepository.showMenu().length; i++) {
                System.out.println("["+i+"]"+" "+ menuRepository.showMenu()[i]);
            }
            int chosenMenuOption = userInput.nextInt();
            String activeMenuOption = menuRepository.showMenuOption(chosenMenuOption);
            System.out.println("---------- "+activeMenuOption+" ----------");
            if (activeMenuOption == "BMI"){
                //show user height
                System.out.println("Height: "+ loggedInUser.getHeight());

                System.out.println("Weight:");
                int userWeight =  userInput.nextInt();
                BmiLogRepository bmiLogRepository = new BmiLogRepository();

                //get BMI value
                double userBmi = bmiLogRepository.calculateBMI(loggedInUser.getHeight(), userWeight);
                System.out.println(Math.round(userBmi * 100.0) / 100.0); //round up to 2 decimals
            }

        }else{
            System.out.println("check given info");
        }
    }
}
