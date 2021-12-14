package view;

import controller.DatabaseController;

public class ProfileMenu extends Menu{
    public ProfileMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show(){
        System.out.println("*******" + this.name + "*******");

        System.out.println("Write \"back\" to go to the Welcome Menu\n" +
                        "Profile --change --oldPassword <old password> --newPassword <new password>\n" +
                        "Profile --change --username <new username>\n" +
                        "Profile --showTeams\n" +
                        "Profile --showTeam <team Name>\n" +
                        "Profile --show --myProfile\n" +
                        "Profile --show logs\n" +
                        "Profile --show notifications\n\n"
        );

    }

    public void execute(){
        Menu nextMenu = this;

        String  input = getInputFromUser("Enter your command in the specified format:");

        String[] split = input.split("\\s+");
        String oldPassword = DatabaseController.proccessInput(split[3]);
        String newPassword = DatabaseController.proccessInput(split[5]);

        if(input.startsWith("Profile --change --oldPassword")){
            String state = DatabaseController.changePassword(oldPassword,newPassword);
            if(state.equals("Password entered incorrectly for the second time")){
                nextMenu = this.parent.parent;
            } else if(state.equals("error")){
                nextMenu = this;
            } else{
                System.out.println(state);
                nextMenu = this;
            }
        } else if(input.startsWith("Profile --change --username")){

        } else if(input.equalsIgnoreCase("Profile --showTeams")){

        } else if(input.startsWith("Profile --showTeam ")){

        } else if(input.equalsIgnoreCase("Profile --show --myProfile")){

        } else if(input.equalsIgnoreCase("Profile --show notifications")){

        }


        nextMenu.show();
        nextMenu.execute();

    }

    public static String handleError(String input){
        if(input.equals("1")){
            System.out.println("wrong old password !" +
                    "retype your password again:");
            String output = scanner.nextLine();
            return output;
        } else if(input.equals("2")){
            System.out.println("Please type a New Password !");
            return "error";
        } else{
            System.out.println("Please Choose A strong Password" +
                    " (Containing at least 8 characters including 1 digit and 1 Capital Letter)");
            return "error";
        }

    }
}
