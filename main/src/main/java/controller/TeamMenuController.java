package controller;

import model.ScoreBoard;
import model.Task;
import model.Team;
import model.User;

import java.util.Scanner;


public class TeamMenuController {
    private static TeamMenuController teamMenuController = new TeamMenuController();

    private TeamMenuController() {
    }

    public static TeamMenuController getTeamMenuController() {
        return teamMenuController;
    }

    public void showAllTeams() {
        // check the user : not admin -> get the user by username -> list


    }

    public boolean isLoggedInUSerAdmin() {

        User user = findLoggedInUSer();
        return (user.isAdmin());
    }


    public static User findAdmin() {

        for (User user : User.getAllUsers().keySet()) {
            if (user.isAdmin()) {// finish is admin method in user
                return user;
            }
        }
        return null;
    }

    private static User findLoggedInUSer() {
        for (User user : User.getAllUsers().keySet()) {
            if (user.getAllUsers().get(user))
                return user;
        }
        return null;
    }

    public void showAllLoggedInUserTeams() {
        // if(user.equals(findLoggedInUSer())) {
        User activeUser = findLoggedInUSer();
        if (!isLoggedInUSerAdmin()) {

            for (int i = 0; i < activeUser.getUserTeams().size(); i++) {
                int teamNumber = i + 1;
                System.out.println(teamNumber + " < " + activeUser.getUserTeams().get(i) + " > ");
            }

        }
    }


    //TODO check the order as said in pdf
    public void showScoreBoard() {
        Team selectedTeam = findEnteredTeam();
        String teamName = selectedTeam.getTeamName();
        System.out.println("* " + teamName + " 's scoreBoard : ");
        for (ScoreBoard scoreBoard : ScoreBoard.getAllScoreBoards()) {
            if (scoreBoard.getTeamName().equals(teamName)) {
                int counter = 0;
                for (String s : scoreBoard.getScoreBoardInfoByTeamName(teamName).keySet()) {
                    counter++;
                    System.out.println(counter + ". " + s + " : " + scoreBoard.getScoreBoardInfoByTeamName(teamName).get(s) + "");

                }
            } else {
                System.out.println("there is no team with this name to show its scoreboard");
            }

        }

    }


    public static void selectTeam(String teamName) {
        // check if team exists
        Team selectedTeam = findEnteredTeam();
        if (selectedTeam != null) {
            System.out.println("one team is already selected if you want to select another " +
                    "\n team first deselect your team then enter another!");
            //return false;

        } else {
            for (Team team : Team.getAllTeams().keySet()) {
                if (team.getTeamName().equalsIgnoreCase(teamName)) {
                    selectedTeam = team;
                }

            }
            if (selectedTeam == null) {
                System.out.println("invalid team name");
            } else {
                Team.getAllTeams().replace(selectedTeam, true);
                System.out.println("" + selectedTeam.getTeamName() + " have been selected successfully!!");
                showSelectedTeam(selectedTeam.getTeamName());
                // return true;

            }
        }

    }

    public static void deselectTeam(String teamName) {
        Team selectedTeam = findEnteredTeam();
        //check if user has logged in at all
        if (selectedTeam == null)
            System.out.println("you must select the team !!!");
        Team.getAllTeams().replace(selectedTeam, false);
        System.out.println("" + selectedTeam.getTeamName() + " has been deselected !");
    }


    public static void showSelectedTeam(String teamName) {
        if (!isTeamEntered()) {
            System.out.println("you must enter your team's name first!");
        } else {
            Team selectedTeam = findEnteredTeam();
            System.out.println(
                    "\nThis is team : " + teamName + "'s page\n" +
                            "* " + teamName + "  scoreboard\n" +
                            "* " + teamName + " chatroom\n" +
                            "* " + teamName + " roadmap\n" +
                            "* " + teamName + " tasks\n" +
                            "* team leader : " + selectedTeam.getTeamLeaderName()
                            + "\n* team members : \n"
            );
            // checkTeamMembers();
        }
    }

    public static void checkTeamMembers() {
        Team selectedTeam = findEnteredTeam();
        if (selectedTeam.getTeamMembers().size() < 2) {
            System.out.println(findLoggedInUSer().getUsername());
            System.out.println("there are no members in this team except you ");
        } else {
            for (int i = 0; i < selectedTeam.getTeamMembers().size(); i++) {
                System.out.println(selectedTeam.getTeamMembers().get(i));
            }

        }

    }



    private static Team findEnteredTeam() {
        for (Team team : Team.getAllTeams().keySet()) {
            if (team.getAllTeams().get(team))
                return team;
        }
        return null;
    }

    public static boolean isTeamEntered() {
        if (findEnteredTeam() != null)
            return true;
        return false;
    }

    public void showRoadMap() {
        Team selectedTeam = findEnteredTeam();
        String teamName = selectedTeam.getTeamName();
        System.out.println("* " + teamName + " 's roadmap : ");
        for (String taskTitle : selectedTeam.getTeamRoadMap().getTaskPercentageDoneInfo().keySet())
            System.out.println("<" + taskTitle + "> : <"
                    + selectedTeam.getTeamRoadMap().getTaskPercentageDoneInfo().get(taskTitle)
                    + "> % done");
    }

    public void showChatRoom() {
        Team selectedTeam = findEnteredTeam();
        String teamName = selectedTeam.getTeamName();
        System.out.println("* " + teamName + " 's chatRoom : ");
        // String sender= findLoggedInUSer().getUsername();
        for (String senderUserName : selectedTeam.getChatRoom().getAllTeamMassages().keySet()){
            System.out.println("<"+senderUserName+"> : <"
                    + selectedTeam.getChatRoom().getAllTeamMassages().get(senderUserName)
                    + ">");
        }

    }
    public static void sendMassage(String massage){
        Team selectedTeam = findEnteredTeam();
        String teamName = selectedTeam.getTeamName();
        String sender= findLoggedInUSer().getUsername();
        selectedTeam.getChatRoom().getAllTeamMassages().put(sender,massage);
        System.out.println("massage added successfully !!!");

    }

    public static void showTaskInfoByID(int taskID){
        Team selectedTeam = findEnteredTeam();
        String teamName = selectedTeam.getTeamName();
        for (Task task: selectedTeam.getTeamsTasks()){
            if (task.getId()==taskID){
                showTask(task);
            }else {
                System.out.println("task with the given id is invalid");
            }

        }
    }
    public static void showAllTasks() {
        Team selectedTeam =findEnteredTeam();
        String teamName= selectedTeam.getTeamName();
        System.out.println(teamName + "tasks : ");

        for (Task task : selectedTeam.getTeamsTasks()) {
            System.out.println("\n ");
            showTaskForAllTasks(task);

        }



    }

    private static void showTaskForAllTasks(Task task) {
        System.out.println("<task title : "+task.getTitle()+ " >\n id <"+
                +task.getId()+"> ,  creation date <"+task.getCreationDate()+
                "> , deadline <"+ task.getDeadline()+
                "> , priority <" +task.getPriority()+
                ">\n assigned to :\n"
        );
        getAssignedUsersUserName( task);

    }

    private static void showTask(Task task) {
        System.out.println("<task title : "+task.getTitle()+ " >\n id <"+
                +task.getId()+">\n  creation date <"+task.getCreationDate()+
                ">\n deadline <"+ task.getDeadline()+
                ">\n priority <" +task.getPriority()+
                ">\n Description <" +task.getDescription()+
                //  ">\n comments <" +task.getComments()+
                ">\n assigned to :\n"
        );
        getAssignedUsersUserName( task);


    }
    public static void getAssignedUsersUserName(Task task){
        for ( User user :task.getAssignedUsers()){
            System.out.println("*<"+user.getUsername()+">\n");
        }
    }
    //
}
