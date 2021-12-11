package model;

import java.util.HashMap;

public class User {


    private final String username;
    private String password1;
    private String password2;
    private String email;
    private final String birthday;
    //
    private static HashMap<User,Boolean> allUsers=new HashMap<>();// to see if user is logged in
    private Boolean isAdmin;
    private Boolean isLeader;

    public static void main(String[] args) {
        Admin admin = new Admin("", "", ",", "");

    }


    public User(String username, String password, String email, String birthday) {
        this.username = username;
        this.password1 = password;
        this.email = email;
        this.birthday = birthday;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password1;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
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
        //showTeam += "1. " + name + "\n";
        n++;
        return showTeam;
    }
    //

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public static HashMap<User, Boolean> getAllUsers() {
        return allUsers;
    }

}