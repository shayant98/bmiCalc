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
        System.out.println("[NAME]: "+ loggedInUser.getName());
        System.out.println("[SURNAME]: "+ loggedInUser.getSurname());
        System.out.println("[HEIGHT]: "+ loggedInUser.getHeight()+ " M");
        System.out.println("[LAST WEIGHT]: "+ userLastBmi.getWeight()+ " KG");
        System.out.println("[LAST BMI]: " + userLastBmi.getBmi());
        System.out.println("[LAST CHECK]: "+ userLastBmi.getDate());
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
