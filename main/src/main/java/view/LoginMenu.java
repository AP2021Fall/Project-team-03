package view;

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
        str.replace(0,str.length(),split[3]);
        String username = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[5]);
        String password = (str.substring(1,str.indexOf(">"))).toString();
        //boolean login = manager.login(username,password);
    }

}
