package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Team> pendingTeams = new ArrayList<Team>();

    // //*
    ScoreBoard teamsScoreBoard ;
    RoadMap teamRoadMap;
    ChatRoom chatRoom;
    private String teamName;

    private String teamLeaderName;
    public static HashMap<Team,Boolean> allTeams=new HashMap<>();// to see if the team is entered or not

    private ArrayList<String> teamMembers = new ArrayList<String>();// the string is username
    private ArrayList<Board> teamsBoards=new ArrayList<>();
    private ArrayList<Task>  teamsTasks = new ArrayList<>();
    //


    public Team(String teamName) {
        this.teamName = teamName;
        allTeams.put(this,false);
    }

    public static HashMap<Team, Boolean> getAllTeams() {
        return allTeams;
    }

    public static Team getTeamById(int id) {
        for (Team team: teams)
            //    if (team.getId() == id)
            return team;
        return null;
    }
    public static Team getTeamByName(String teamName){
        for (Team team:teams){
            if(team.getTeamName().equalsIgnoreCase(teamName))
                return team;
        }
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

    public RoadMap getTeamRoadMap() {
        return teamRoadMap;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
