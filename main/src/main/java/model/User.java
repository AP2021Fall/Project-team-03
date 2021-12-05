package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

    private final String name;
    private final String username;
    private String password;
    private String password2;
    private String email ;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        users.add(this);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password,String password2) {
        this.password = password;
        this.password2 = password2;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }


}