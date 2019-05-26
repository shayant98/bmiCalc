package sr.unasat.bmi.calculator.app;

import sr.unasat.bmi.calculator.repositories.UserRepository;

public class Application {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        //test db function
       userRepository.findAllUsers().forEach(user -> System.out.println(user.getName()));

    }
}
