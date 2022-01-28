import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello this is a test");

        MainMenu mainMenu =new MainMenu("MainMenu", null);
        mainMenu.show();
        mainMenu.execute();
    }
}
