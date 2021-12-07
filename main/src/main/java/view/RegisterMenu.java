package view;

public class RegisterMenu extends Menu{
    public RegisterMenu(String name, Menu parent) {
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
                "user create --username <username> --password1 <password> --password2 <password> --email Address <email>");
        //duplicate code
        String[] split = input.split("\\s+");
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
            nextMenu = this;
        } else{
            //tabeye register
            nextMenu = this.parent.subMenus.get(4);
        }


    }

}
