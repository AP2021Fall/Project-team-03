package view;

public class TeamMenu extends Menu{
    public TeamMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {
        System.out.println("*******" + this.name + "*******");
        System.out.println("In this menu you can : \n"+
                "1. Go to previous menu\n" +
                "2. View your teams\n"+
                "3. View your team's scoreboards\n"+
                "4. View your team's roadmaps\n"+
                "5. View your team's chatroom\n" +
                "6. View your task's options\n" +
                "7. Go to Board Menu\n"+
                "You can see the commands to perform the next action by writing : show commands");// case insensitive // a method for all
        subMenus.put(2, new BoardMenu("BoardMenu", this));
        super.show();
        // print teams
    }

    @Override
    public void execute() {

        Menu nextMenu = this;
       // String  input = getInputFromUser("");

    }
    private String showCommands() {
        return "Enter your commands in the specified format\n" +
                "to ";
    }

}


