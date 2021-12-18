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
    @Override
    public void execute(){
        Menu nextMenu = this;

        String  input = getInputFromUser("Enter your command in the specified format:");

        String[] split = input.split("\\s+");


        if(input.startsWith("Profile --change --oldPassword")){
            String oldPassword = DatabaseController.proccessInput(split[3]);
            String newPassword = DatabaseController.proccessInput(split[5]);
            String state = DatabaseController.changePassword(oldPassword,newPassword);
            if(state.equals("exit")){
                nextMenu = this.parent.parent;
            } else if(state.equals("error")){
                nextMenu = this;
            } else if(state.equals("successfull")){
                nextMenu = this;
            }
        } else if(input.startsWith("Profile --change --username")){
            String newUsername = DatabaseController.proccessInput(split[3]);
            String state = DatabaseController.changeUsername(newUsername);
            if(state.equals("error")){
                nextMenu = this;
            } else if(state.equals("successfull")){
                nextMenu = this;
            }
        } else if(input.equalsIgnoreCase("Profile --showTeams")){
            System.out.println(DatabaseController.showTeams());
        } else if(input.startsWith("Profile --showTeam ")){
            String teamName = DatabaseController.proccessInput(split[2]);

        } else if(input.equalsIgnoreCase("Profile --show --myProfile")){
            System.out.println(DatabaseController.showMyProfile());
        } else if(input.equalsIgnoreCase("Profile --show notifications")){

        }


        nextMenu.show();
        nextMenu.execute();

    }

    public static String handleErrorChangePass(String input){
        if(input.equals("1")){
            System.out.println("wrong old password !" +
                    "retype your old password again:(only old password)");
            String output = scanner.nextLine();
            return output;
        } else if(input.equals("2")){
            System.out.println("Password entered incorrectly for the second time");
            return "exit";
        }  else if(input.equals("3")){
            System.out.println("Please type a New Password !");
            return "error";
        } else  if(input.equals("4")){
            System.out.println("Please Choose A strong Password" +
                    " (Containing at least 8 characters including 1 digit and 1 Capital Letter)");
            return "error";
        } else{
            System.out.println("Password has changed successfully!");
            return "successfull";
        }
    }
    public static String handleErrorChangeUsername(String input){
        if(input.equals("1")){
            System.out.println("Your new username must include at least 4 characters!");
            return "error";
        } else if(input.equals("2")){
            System.out.println("username already taken!");
            return "error";
        } else if(input.equals("3")){
            System.out.println("New username contains Special Characters! Please remove them and try again");
            return "error";
        } else if(input.equals("4")){
            System.out.println("you already have this username !");
            return "error";
        } else{
            System.out.println("Username has changed successfully!");
            return "successfull";
        }
    }




}
