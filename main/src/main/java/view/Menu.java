package view;

import controller.DatabaseController;
import model.Database;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Menu {

    protected String name;
    protected Menu parent;
    protected HashMap<Integer, Menu> subMenus;
    protected static Scanner scanner = new Scanner(System.in);
    protected static StringBuilder str;
    protected final Database database;
    protected static DatabaseController databaseController;
    public Menu(String name, Menu parent) {
        this.name = name;
        this.parent = parent;
        this.subMenus = new HashMap<>();
        this.str = new StringBuilder();
        this.database = new Database();
        this.databaseController = new DatabaseController(database);

    }

    public String getName() {
        return name;
    }

    public Menu getParent() {
        return parent;
    }

    public HashMap<Integer, Menu> getSubMenus() {
        return subMenus;
    }

    public void show(){
        System.out.println("*******" + this.name + "*******");
        if(this.parent != null){
            System.out.println("1.Back");
        } else{
            System.out.println("1.Exit");
        }
        for (Integer integer : this.getSubMenus().keySet()) {
            System.out.println("" + integer + "." + this.getSubMenus().get(integer).getName());
        }
    }
    public void execute(){
        Menu nextMenu = this;
        String input = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        int choice;
        if(matcher.find()){
            choice = Integer.parseInt(input);
            if(choice == 1){
                if(this.parent == null){
                    System.exit(1);
                } else{
                    nextMenu = this.parent;
                }
            } else if(choice>1 && choice<(this.subMenus.size()+2)){
                nextMenu = this.subMenus.get(choice);
            } else{
                System.out.println("Your input is invalid!");
            }
        }
        nextMenu.show();
        nextMenu.execute();

    }

    public void returnToParentMenu(String input){
        if(input.trim().equalsIgnoreCase("end")){
            this.parent.show();
            this.parent.execute();
        }
    }

    public String getInputFromUser(String text){
        System.out.println(text);
        String input = scanner.nextLine();
        returnToParentMenu(input);
        return input;
    }
}
