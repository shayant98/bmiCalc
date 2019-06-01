package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.BmiLog;
import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.BmiLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

class UserInfoView {
    private User loggedInUser;

    public UserInfoView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showUserInfoScreen(){
        BmiLogRepository bmiLogRepository = new BmiLogRepository();
        BmiLog userLastBmi = bmiLogRepository.getSingleBmiLogByUserId(loggedInUser.getId());
        System.out.println("Name: "+ loggedInUser.getName());
        System.out.println("Surname: "+ loggedInUser.getSurname());
        System.out.println("Height: "+ loggedInUser.getHeight()+ " M");
        System.out.println("Last Weight: "+ userLastBmi.getWeight()+ " KG");
        System.out.println("Last BMI: " + userLastBmi.getBmi());
        System.out.println("last check: "+ userLastBmi.getDate());
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
