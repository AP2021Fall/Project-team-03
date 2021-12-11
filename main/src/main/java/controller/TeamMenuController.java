package controller;

import model.User;


public class TeamMenuController {
    private static TeamMenuController teamMenuController= new TeamMenuController();

    private TeamMenuController() {
    }

    public static TeamMenuController getTeamMenuController() {
        return teamMenuController;
    }

    public  void showAllTeams() {
        // check the user : not admin -> get the user by username -> list




    }
    public boolean isLoggedInUSerAdmin (){

        User user = findLoggedInUSer();
        return (user.isAdmin());
    }



    public static User findAdmin(){

        for(User user: User.getAllUsers().keySet()){
            if(user.isAdmin()){// finish is admin method in user
                return user;
            }
        }
        return null;
    }

    private static User findLoggedInUSer() {
        for (User user:User.getAllUsers().keySet()){
            if (user.getAllUsers().get(user))
                return user;
        }return null;
    }


}
