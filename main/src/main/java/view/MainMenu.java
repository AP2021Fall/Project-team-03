package view;

public class MainMenu extends Menu{

    public MainMenu(String name, Menu parent) {
        super(name, parent);

        subMenus.put(2, new WelcomeMenu(" WelcomeMenu", this));
        subMenus.put(3, new RegisterMenu(" RegisterMenu", this));
        subMenus.put(4, new LoginMenu(" LogInMenu", this));
        subMenus.put(5, new ProfileMenu(" ProfileMenu", this));
        subMenus.put(6, new TaskMenu(" TaskMenu",this));
        subMenus.put(7, new TeamMenu(" TeamMenu",this));
        subMenus.put(8, new CalenderMenu(" CalenderMenu",this));
        subMenus.put(9, new NotificationMenu(" NotificationMenu",this));
        // subMenus.put(10,new LogoutMenu(". LogoutMenu", this));
    }
    public void show() {
//        if(TeamMenuController.isUserLoggedIn()){
//            this.getSubMenus().clear();
//            this.subMenus.put(2,new LogoutMenu(". log out menu",this));
//        this.subMenus.put(3, new RegisterMenu(". RegisterMenu", this));
//        this.subMenus.put(4, new LoginMenu(". LogInMenu", this));
//        this.subMenus.put(5, new ProfileMenu(". ProfileMenu", this));
//        this.subMenus.put(6, new TaskMenu(". TaskMenu",this));
//        this.subMenus.put(7, new TeamMenu(". TeamMenu",this));
//        this.subMenus.put(8, new CalenderMenu(". CalenderMenu",this));
//        this.subMenus.put(9, new NotificationMenu(". NotificationMenu",this));

//        }else{
        subMenus.put(2, new WelcomeMenu(" WelcomeMenu", this));
        subMenus.put(3, new RegisterMenu(" RegisterMenu", this));
        subMenus.put(4, new LoginMenu(" LogInMenu", this));
        subMenus.put(5, new ProfileMenu(" ProfileMenu", this));
        subMenus.put(6, new TaskMenu(" TaskMenu",this));
        subMenus.put(7, new TeamMenu(" TeamMenu",this));
        subMenus.put(8, new CalenderMenu(" CalenderMenu",this));
        subMenus.put(9, new NotificationMenu(" NotificationMenu",this));
        // }
        super.show();
    }

    @Override
    public void execute() {
        super.execute();
    }
}

