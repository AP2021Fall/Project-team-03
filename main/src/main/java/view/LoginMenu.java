package view;

import controller.DatabaseController;

public class LoginMenu extends Menu{
    public LoginMenu(String name, Menu parent) {
        super(name, parent);
    }
    @Override
    public void show(){
        System.out.println("*******" + this.name + "*******");

        System.out.println("Write \"back\" to go to the Welcome Menu:");

    }
    @Override
    public void execute(){
        Menu nextMenu = this;
        String  input = getInputFromUser("Enter your commands in the specified format\n" +
        "user login --username <username> --password <password>");

        String[] split = input.split("\\s+");
        String username = DatabaseController.proccessInput(split[3]);
        String password = DatabaseController.proccessInput(split[5]);


        String state = databaseController.login(username,password);
        if(state.equalsIgnoreCase("There isn't any user with this username!")){
            System.err.println(state);
            nextMenu = this;
        } else if(state.equalsIgnoreCase("Your password is incorrect")){
            System.err.println(state);
            nextMenu = this;
        } else if(state.equalsIgnoreCase("You have successfully logged in")){
            System.out.println(state);
            nextMenu = this.parent.subMenus.get(4);
        }

        nextMenu.show();
        nextMenu.execute();

    }

}
