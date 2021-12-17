package controller;

import model.ScoreBoard;
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
            if(user.isAdmin()){
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

    public void showTeams(User user){
        if(user.equals(findLoggedInUSer())) {
            if (!isLoggedInUSerAdmin()) {

                for (int i = 0; i < user.getUserTeams().size(); i++) {
                    int teamNumber = i + 1;
                    System.out.println(teamNumber + " < " + user.getUserTeams().get(i) + " > ");
                }

            }
        }




    }//TODO arrange method
    public void showScoreBoard (String teamName){
        for(ScoreBoard scoreBoard: ScoreBoard.getAllScoreBoards()){
            if(scoreBoard.getTeamName().equals(teamName)){
                int counter= 0;
                for (String s :  scoreBoard.getScoreBoardInfoByTeamName(teamName).keySet()){
                    //  scores.add(test.get(s));
                    counter++;
                    System.out.println(counter+". " + s + " : " + scoreBoard.getScoreBoardInfoByTeamName(teamName).get(s)+"");

                }
            }

        }

    }
    public void showRoadMap(String teamName){

    }


}
