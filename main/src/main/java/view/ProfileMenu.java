package view;

public class ProfileMenu extends Menu{
    public ProfileMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show(){
        System.out.println("*******" + this.name + "*******");

        System.out.println("Write \"back\" to go to the Welcome Menu:");

    }


}
