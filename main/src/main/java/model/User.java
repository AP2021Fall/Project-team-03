package model;

import java.util.ArrayList;

public class User {

    private final String name;
    private final String username;
    public int id;
    private String password1;
    private String password2;
    private String email;
    private Role role;


    Database database = new Database();

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password1 = password;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role newRole) {
        role = newRole;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password, String password2) {
        this.password1 = password;
        this.password2 = password2;
    }

    public String showTeams() {
        String showTeam = "";
        String teamName;
        for (int i = teams.size(); i > 0; i--) {
            teamName = teams.get(i).getName();
            showTeam += String.valueOf(teams.size() - i + 1) + ". " + teamName + "\n";
        }
        return showTeam;
    }

    public String showTeam(String teamName) {
        Team team = Team.getTeamByName(teamName);
        String showTeam;
        ArrayList<String> member = team.getMember();
        int n = 1;
        showTeam = "name: " + teamName + "\n";
        showTeam += "leader: " + team.getLeader().name + "\n";
        if (!team.getLeader().name.equals(name)) {
            showTeam += "1. " + name + "\n";
            n++;
        }
        for (int i = 1; i <= member.size(); i++) {
            if (member.get(i).equals(name)) {
                member.remove(name);
            }
        }
        for (String Name : member) {
            showTeam += n + ". " + Name + "\n";
        }
        return showTeam;
    }

    public String showTeamTasks(String teamName) {
        Team team = Team.getTeamByName(teamName);
        return team.showTasks();
    }

    public String showTeam(String teamName) {
        Team team = Team.getTeamByName(teamName);
        String showTeam;
        ArrayList<String> member = team.getMember();
        int n = 1;
        showTeam = "name: " + teamName + "\n";
        showTeam += "leader: " + team.getLeader().name + "\n";
        if (!team.getLeader().name.equals(name)) {
            showTeam += "1. " + name + "\n";
            n++;
        }
        for (int i = 1; i <= member.size(); i++) {
            if (member.get(i).equals(name)) {
                member.remove(name);
            }
        }
        for (String Name : member) {
            showTeam += n + ". " + Name + "\n";
        }
        return showTeam;
    }

    public static String showProfile(String username) {
        User user = getUserByUsername(username);
        return user.showProfile();
    }

    public boolean teamsExists() {
        if (teams.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean teamExists(String Name) {
        for (Team team : teams) {
            if (team.getName().equals(Name)) {
                return true;
            }
        }
        return false;
    }

    public boolean teamExists(int Id) {
        for (Team team : teams) {
            if (team.getId() == id) {
                return true;
            }
        }
        return false;
    }

}