package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.BmiLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

import java.util.Scanner;

public class BmiCalculator {
    private User loggedInUser;
    Scanner userInput = new Scanner(System.in); //om userinput van CLI te accepteren

    public BmiCalculator(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }




    public void showBmiCalculatorScreen(){
        //show user height
        System.out.println("Height: "+ loggedInUser.getHeight());
        System.out.println("Weight:");
//        TODO: validate if value is INT
        if(userInput.hasNextInt()){
        int userWeight =  userInput.nextInt();
        BmiLogRepository bmiLogRepository = new BmiLogRepository();

        //get BMI value
        double userBmi = bmiLogRepository.calculateBMI(loggedInUser.getHeight(), userWeight);
        System.out.println(userBmi);
        String bmiMessage = bmiLogRepository.checkBmiRange(userBmi);
        System.out.println(bmiMessage);
        Helper helper = new Helper(loggedInUser);
        helper.returnToMenu();


    }
}}
