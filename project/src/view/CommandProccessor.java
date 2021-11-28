package view;

import controller.Manager;

import java.util.Scanner;

public class CommandProccessor {
    Manager manager;
    Scanner scanner;
    StringBuilder str;
    public CommandProccessor(Manager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
        this.str = new StringBuilder();
    }

    void run(){
        //version?
        System.out.println("Welcome");
        String input;
        while(!(input = scanner.nextLine()).equalsIgnoreCase("end")){
            if(input.startsWith("user create")){
                registerProccess(input.split("\\s+"));
            } else if(input.startsWith("user login")){
                loginProccess(input.split("\\s+"));
            } else if(input.startsWith("")){

            } else if(input.startsWith("")){

            } else if(input.startsWith("")){

            } else if(input.startsWith("")){

            }
        }
    }

    private void registerProccess(String[] split) {
        str.replace(0,str.length(),split[3]);
        String username = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[5]);
        String password1 = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[7]);
        String password2 = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[10]);
        String email = (str.substring(1,str.indexOf(">"))).toString();
        if(!password1.equals(password2)){
            System.err.println("Your passwords are not the same!");
        }
        manager.register(username,password1,email);
    }

    private void loginProccess(String[] split) {
        str.replace(0,str.length(),split[3]);
        String username = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[5]);
        String password = (str.substring(1,str.indexOf(">"))).toString();
        boolean login = manager.login(username,password);
        if(login){
            mainMenu(username);
        }

    }

    private void mainMenu(String username) {
        System.out.println("Menu Items:\n" +
                "1. Profile Menu\n" +
                "2. Team Menu → { Chat Room – Board Menu– ScoreBoard – RoadMaps }\n" +
                "3. Tasks Page\n" +
                "4. Calendar Menu\n" +
                "5. Notification Bar\n" +
                "6. logout\n" +
                "Select the corresponding number or item name to enter the desired menu item:")
        String input;
        while((input = scanner.nextLine()).equalsIgnoreCase("logout")){
            if(input.equals("1") || input.equalsIgnoreCase("Profile Menu")){

            } else if(input.equals("2") || input.equalsIgnoreCase("Team Menu")){

            } else if(input.equals("3") || input.equalsIgnoreCase("Tasks Page")){

            } else if(input.equals("4") || input.equalsIgnoreCase("Calendar Menu")){

            } else if(input.equals("5") || input.equalsIgnoreCase("Notification Bar")){

            }
        }
        //logout
    }
}


    private void changeProfileItems(String username) {
        System.out.println("Profile Menu Commands:\n" +
                "Profile --change --oldPassword <old password> --newPassword <new password>\n" +
                "Profile --change --username <new username>");
        String input = scanner.nextLine();
        if (input.startsWith("Profile --change --oldPassword")) {
            changePasswordProccess(username,input.split("\\s+"));
        } else if (input.startsWith("Profile --change --username")) {
            changeUsernameProccess(username, input.split("\\s+"));
        } else if (input.equals("Profile --showTeams")) {
            manager.showTeams(username);
        } else if (input.equals("Profile --showTeam ")) {
            showTeamByNameProccess(username, input.split("\\s+"));
        }
    }

    private void changePasswordProccess(String username, String[] split) {
        str.replace(0,str.length(),split[3]);
        String password1 = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[5]);
        String password2 = (str.substring(1,str.indexOf(">"))).toString();
        manager.changePassword(username,password1,password2);
    }

    private void changeUsernameProccess(String username, String[] split) {
        str.replace(0,str.length(),split[3]);
        String newUsername = (str.substring(1,str.indexOf(">"))).toString();
        manager.changeUsername(username,newUsername);

    }

    private void showTeamByNameProccess(String username, String[] split) {
        str.replace(0,str.length(),split[2]);
        String teamName = (str.substring(1,str.indexOf(">"))).toString();
        manager.showTeamByName(username,teamName);
    }




}
