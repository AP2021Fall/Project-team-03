package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private int id;
    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Team> pendingTeams = new ArrayList<Team>();

    //
    ScoreBoard teamsScoreBoard ;
    RoadMap teamRoadMap;
    ChatRoom chatRoom;
    private String teamName;
    private String teamLeaderName;
    public static HashMap<Team,Boolean> allTeams=new HashMap<>();// to see if the team is entered or not


    private ArrayList<User> teamMembers;
    private ArrayList<Board> teamsBoards;
    private static ArrayList<Task>  teamsTasks = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
        allTeams.put(this,false);
    }
    public static HashMap<Team, Boolean> getAllTeams() {
        return allTeams;
    }

    public Team() {
        this.teamMembers = new ArrayList<User>();
        this.teamsBoards = new ArrayList<Board>();
    }

    public static Team getTeamById(int id) {
        for (Team team: teams)
            if (team.getTeamId() == id)
                return team;
        return null;
    }

    public int getTeamId() {
            if(allTeams.isEmpty()) {
                this.id = 0;
            }else {
                int lastIndex=allTeams.size()-1;
                int lastId=allTeams.get(lastIndex).getTeamId();
                this.id=lastId+1;

            }
            return id;
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



    public ArrayList<User> getTeamMembers() {
        return teamMembers;
    }
   // public ArrayList<String>getTeamMembersByTeamName (String teamName) {return teamMembers;}


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
    //TODO fix this method : show task in team
    public RoadMap getTeamRoadMap() {
        return teamRoadMap;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public String showTasks() {
        return null;
    }
}
