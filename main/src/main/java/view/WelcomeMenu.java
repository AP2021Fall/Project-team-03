package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WelcomeMenu extends Menu{

    public WelcomeMenu(String name, Menu parent) {
        super(name, parent);
        this.subMenus.put(2, new RegisterMenu("Register Menu", this));
        this.subMenus.put(3, new LoginMenu("Login Menu", this));

    }
    @Override
    public void show(){

        System.out.println("WeLcOmE To OuR PrOgRaM\n" +
                "Enter \"1\" to sign up\n" +
                "Enter \"2\" to login\n" +
                "Enter \"end\" to exit");

    }
    @Override
    public void execute(){
        Menu nextMenu = this;
        String input = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        int choice;

        if(matcher.find()){
            choice = Integer.parseInt(input);
            if(choice == 1){
                nextMenu = this.getSubMenus().get(2);
            } else if(choice == 2){
                nextMenu = this.getSubMenus().get(3);
            } else if(choice == 3){
                System.exit(1);
            } else{
                System.out.println("Your input is invalid genius!!!");
            }
        }
        nextMenu.show();
        nextMenu.execute();
    }
}