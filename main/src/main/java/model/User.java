package model;

import java.util.ArrayList;

public class User {

    private final String name;
    private final String username;
    private String password1;
    private String password2;
    private String email;

    public static void main(String[] args) {
        Admin admin = new Admin("", "", ",", "");

    }


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

    public void setPassword(String password, String password2) {
        this.password1 = password;
        this.password2 = password2;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password1.equals(password);
    }

    public String showTeam(String teamName) {
        //  Team team = Team.getTeamByName(teamName);
        String showTeam;
        //  ArrayList<String> member = team.getMember();
        int n = 1;
        showTeam = "name: " + teamName + "\n";
        // showTeam += "leader: "+team.getLeader().name+"\n";
        // if(!team.getLeader().name.equals(name)){
        showTeam += "1. " + name + "\n";
        n++;
    }


}