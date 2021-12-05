package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

    private final String name;
    private final String username;
    private String password;
    private String password2;
    private String email;
    private boolean isAdmin;
    private String role;
    private ArrayList<String> joinedTeams;
    private  Database database;



    public User(String name, String username, String password, String password2, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.email = email;
        database.addUser(this);
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setLoggedIn(boolean loggedIn) {
        isAdmin = isAdmin;
    }


}