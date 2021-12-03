package view;

public class WelcomeMenu extends Menu {

    public WelcomeMenu() {
        System.out.println("* Welcome to Trello *");
    }

    @Override
    public Menu run() {

        System.out.println(help() + "Please select a number:");
        switch (INPUT.nextLine().trim()) {
            case "1":
                return new RegistrationMenu();

            case "2":
                return new LoginMenu();

            case "3":
                System.out.println("Hope you great time!");
                System.exit(0);

            default:
                System.out.println("Invalid number!\n" +
                        "try again...");
        }
        return this;
    }

    @Override
    public String help() {
        return "1. Register\n" +
                "2. Sign in\n" +
                "3. Exit\n";
    }
}
