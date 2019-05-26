package sr.unasat.bmi.calculator.repositories;

public class MenuRepository {
    private String[] menuOptions = {
            "BMI",
            "Height",
            "Food",
    };
    public MenuRepository(boolean isLoggedIn) {
        if(!isLoggedIn){
            System.exit(1);
        }else{
            showMenu();
        }
    }

    public String[] showMenu(){
        return menuOptions;
    }

    public String showMenuOption(int menuItem){
        return menuOptions[menuItem];
    }
}
