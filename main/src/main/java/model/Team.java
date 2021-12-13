package model;

import java.util.ArrayList;

public class Team {
    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Team> pendingTeams = new ArrayList<Team>();

    //
    ScoreBoard teamsScoreBoard ;
    private String teamName;
    private String teamLeaderName;

    private ArrayList<String> teamMembers = new ArrayList<String>();
    private ArrayList<Board> teamsBoards=new ArrayList<>();
    private ArrayList<Task>  teamsTasks = new ArrayList<>();

    public static Team getTeamById(int id) {
        for (Team team: teams)
        //    if (team.getId() == id)
                return team;
        return null;
    }
    //

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static ArrayList<Team> getPendingTeams() {
        return pendingTeams;
    }

    public ArrayList<String> getTeamMembers() {
        return teamMembers;
    }
    public ArrayList<String>getTeamMembersByTeamName (String teamName) {return teamMembers;}


    public ArrayList<Board> getTeamsBoards() {
        return teamsBoards;
    }

    public ArrayList<Task> getTeamsTasks() {
        return teamsTasks;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public ScoreBoard getTeamScoreBoard() {
        return teamsScoreBoard;
    }

}
