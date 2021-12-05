package model;

import java.util.ArrayList;

public class Team {
    public static ArrayList<Team> teams = new ArrayList<Team>();
    public static ArrayList<Team> pendingTeams = new ArrayList<Team>();

    public static Team getTeamById(int id) {
        for (Team team: teams)
            if (team.getId() == id)
                return team;
        return null;
    }
}
