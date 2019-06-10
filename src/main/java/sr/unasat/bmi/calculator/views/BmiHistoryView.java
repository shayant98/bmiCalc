package sr.unasat.bmi.calculator.views;

import sr.unasat.bmi.calculator.entities.User;
import sr.unasat.bmi.calculator.repositories.BmiLogRepository;
import sr.unasat.bmi.calculator.services.Helper;

public class BmiHistoryView {
    private User loggedInUser;


    public BmiHistoryView(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showBmiHistoryScreen(){
        BmiLogRepository bmiLogRepository = new BmiLogRepository();
          bmiLogRepository.getAllBmiLogByUserId(loggedInUser.getId()).forEach(bmiLog -> {
           String bmiMessage =  bmiLogRepository.checkBmiRange(bmiLog.getBmi());
            System.out.println("[DATE]: "+ bmiLog.getDate() + " [WEIGHT]: " + bmiLog.getWeight()+ " KG [BMI]: " + bmiLog.getBmi()+ " [CONCLUSION]: "+ bmiMessage);
        });
        Helper helper = new Helper();
        helper.returnToMenu(loggedInUser);
    }
}
