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
                "user create --username <username> --password1 <password> --password2 <password>" +
                " --email Address <email> --birthday <yyyy/mm/dd> --roll <roll>");
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
        str.replace(0,str.length(),split[12]);
        String birthday = (str.substring(1,str.indexOf(">"))).toString();
        str.replace(0,str.length(),split[14]);
        String roll = (str.substring(1,str.indexOf(">"))).toString();
        if(!password1.equals(password2)){
            System.err.println("Your passwords are not the same!");
            nextMenu = this;
        } else{
            //tabeye register
            String state = databaseController.register(username,password1,email,birthday,roll);
            if(state.equalsIgnoreCase("This username is already registered")){
                System.err.println(state);
                nextMenu = this;
            } else if(state.equalsIgnoreCase("Select the password in the following format")){
                System.err.println("Select the password in the following format\n" +
                        "Minimum 1 and maximum 3 digits at the beginning" +
                        " - one big character - minimum 3 and maximum 7 small characters");
                nextMenu = this;
            } else if(state.equalsIgnoreCase("Your registration was successful!")){
                System.out.println(state);
                nextMenu = this.parent.subMenus.get(4);
            }
        }

        nextMenu.show();
        nextMenu.execute();
    }

}
