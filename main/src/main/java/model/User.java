package model;

import java.util.ArrayList;
import java.util.HashMap;

import static model.Team.allTeams;

public class User {
    private final String name;

    private String username;
    public int id;
    private String password1;
    //private String password2;
    private String email;
    private Role role;
    private final String birthday;
    private int score;
    private static HashMap<User,Boolean> allUsers=new HashMap<>();// to see if user is logged in
    private Boolean isAdmin;
    private Boolean isLeader;
    private ArrayList<String> userTeams=new ArrayList<>();

    public ArrayList<String> getUserTeams() {
        return userTeams;
    }


    public static void main(String[] args) {
        Admin admin = new Admin("", "", ",", "");

    }

    Database database = new Database();


    public User(String name,String username, String password, String email, String birthday) {
       this.name=name;
        this.username = username;
        this.password1 = password;
        this.email = email;
        this.birthday = birthday;

    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
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

    public String getPassword() {
        return password1;
    }

    public void setRole(Role newRole) {
        role = newRole;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

//    public void setPassword(String password, String password2) {
//    }


    public String showTeams() {
        String showTeam = "";
        String teamName;
        for (int i = allTeams.size(); i > 0; i--) {
            teamName = allTeams.get(i).getTeamName();
            showTeam += String.valueOf(allTeams.size() - i + 1) + ". " + teamName + "\n";
        }
        return showTeam;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password1.equals(password);
    }
/*
    public String showTeam(String teamName) {
        Team team = Team.getTeamByName(teamName);
        //  Team team = Team.getTeamByName(teamName);
        String showTeam;
        ArrayList<String> member = team.getTeamMembers();
        //  ArrayList<String> member = team.getMember();
        int n = 1;
        showTeam = "name: " + teamName + "\n";
        showTeam += "leader: " + team.getTeamLeaderName()+ "\n";
        if (!team.getTeamLeaderName().equals(name)) {
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
        // showTeam += "leader: "+team.getLeader().name+"\n";
        // if(!team.getLeader().name.equals(name)){
        //showTeam += "1. " + name + "\n";
        n++;
        return showTeam;
    }
    */
/*
    public String showTeamTasks(String teamName) {
        Team team = Team.getTeamByName(teamName);
        return team.showTasks();
    }*/

//                            public String showTeam (String teamName){
//                                Team team = Team.getTeamByName(teamName);
//                                String showTeam;
//                                ArrayList<String> member = team.getMember();
//                                int n = 1;
//                                showTeam = "name: " + teamName + "\n";
//                                showTeam += "leader: " + team.getLeader().name + "\n";
//                                if (!team.getLeader().name.equals(name)) {
//                                    showTeam += "1. " + name + "\n";
//                                    n++;
//                                }
//                                for (int i = 1; i <= member.size(); i++) {
//                                    if (member.get(i).equals(name)) {
//                                        member.remove(name);
//                                    }
//                                }
//                                for (String Name : member) {
//                                    showTeam += n + ". " + Name + "\n";
//                                }
//                                return showTeam;
//                            }

    public  String showProfile(String username) {
        User user = getUserByUsername(username);
        return user.showProfile(username);
    }

    private User getUserByUsername(String username) {
        return this;
    }

    public boolean teamsExists() {
        if (allTeams.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean teamExists(String Name) {
        for (Team team : allTeams) {
            if (team.getTeamName().equals(Name)) {
                return true;
            }
        }
        return false;
    }

    public boolean teamExists(int Id) {
        for (Team team : allTeams) {
            if (team.getTeamId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public static HashMap<User, Boolean> getAllUsers() {
        return allUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name + "\n" +
                ", username=" + username + "\n" +
                ", email=" + email + "\n" +
                ", role=" + role + "\n" +
                ", birthday=" + birthday + "\n" +
                ", score=" + score + "\n" +
                '}';
    }
}
