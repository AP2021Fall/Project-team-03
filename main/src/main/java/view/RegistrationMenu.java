package view;

import model.User;

import java.time.LocalDateTime;
public class RegistrationMenu extends Menu {

    public RegistrationMenu() {
        System.out.println("* Registration Menu *");
    }

    @Override
    public Menu run() {

        System.out.println(help() + "Please select a number:");
        switch (INPUT.nextLine().trim()) {
            case "1":
                return getSignupInfo();

            case "2":
                return new WelcomeMenu();

            default:
                System.out.println("Invalid number!\n" +
                        "try again...");
                return this;
        }
    }

    private Menu getSignupInfo() {
        System.out.println("Full Name:");
        String fullName = INPUT.nextLine().trim();
        System.out.println("Username:");
        String username = INPUT.nextLine().trim();
        System.out.println("Note: " + PASSWORD_CONDITION + "\nPassword:");
        String password = INPUT.nextLine().trim();
        System.out.println("Enter your password again:");
        String equalPassword = INPUT.nextLine().trim();
        System.out.println("Enter your  email address:");
        String email = INPUT.nextLine().trim();

        return signup(fullName, username, password, equalPassword, email);
    }

    public Menu signup(String fullName, String username, String password, String equalPassword, String email) {


    }

    @Override
    public String help() {
        return "1. User Create \n" +
                "2. Back\n";
    }
}