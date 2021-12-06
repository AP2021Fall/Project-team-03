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
                return signup();

            case "2":
                return new WelcomeMenu();

            default:
                System.out.println("Invalid number!\n" +
                        "try again...");
                return this;
        }
    }

    private Menu signup() {

    }

    public Menu signup(String fullName, String username, String password, String equalPassword, String email) {


    }



}