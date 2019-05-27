package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.BmiLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

public class BmiHistory {
    private User loggedInUser;


    public BmiHistory(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showBmiHistoryScreen(){
        BmiLogRepository bmiLogRepository = new BmiLogRepository();
        System.out.println("Date      | Weight  | BMI |");
          bmiLogRepository.getAllBmiLogByUserId(loggedInUser.getId()).forEach(bmiLog -> {
           String bmiMessage =  bmiLogRepository.checkBmiRange(bmiLog.getBmi());
            System.out.println(bmiLog.getDate() + "| " + bmiLog.getWeight()+ " KG| " + bmiLog.getBmi()+ "| -----> "+ bmiMessage);
        });
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
