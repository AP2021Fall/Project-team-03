package model;

import java.util.ArrayList;

public class Team {
    private int id;
    public static ArrayList<Team> allTeams = new ArrayList<Team>();
    public static ArrayList<Team> pendingTeams = new ArrayList<Team>();

    //
    ScoreBoard teamsScoreBoard ;
    private String teamName;
    private String teamLeaderName;

    private ArrayList<String> teamMembers = new ArrayList<String>();
    private ArrayList<Board> teamsBoards=new ArrayList<>();
    private ArrayList<Task>  teamsTasks = new ArrayList<>();

    public static Team getTeamById(int id) {
        for (Team team: allTeams)
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
    //

    public static ArrayList<Team> getTeams() {
        return allTeams;
    }

    public static ArrayList<Team> getPendingTeams() {
        return pendingTeams;
    }

    public  Team getTeamByName(String teamName) {
        return this;
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
    //TODO fix this method : show task in team

    public String showTasks() {
        return null;
    }
}
