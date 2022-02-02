package com.example.project03withfx.controller;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


        import com.example.project03withfx.model.*;
        import com.example.project03withfx.fxView.*;

        import java.time.LocalDateTime;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class DatabaseController {
    private static Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public static String proccessInput(String input){
        Menu.str.replace(0,Menu.str.length(),input);
        String in = Menu.str.substring(1,Menu.str.indexOf(">"));
        return in;
    }

    public static String register(String name, String username, String password, String birthday, String email, String role) {
        for (User user : User.getAllUsers().keySet()) {
            if(user.getUsername().equals(username)){
                return "This username is already registered";
            }
        }
        if(!checkPasswordRegex(password)){
            return "Select the password in the following format";
        }
        System.out.println(role);
        if(role.trim().equalsIgnoreCase("Admin")){
            new User(name,username,password,email,birthday, Role.ADMIN);
            //System.out.println(database.users.toString());
            return "Your registration was successful!";
        } else if(role.trim().equalsIgnoreCase("Leader")){
            new User(name,username,password,email,birthday, Role.LEADER);
            //System.out.println(database.users.toString());
            return "Your registration was successful!";
        }else if(role.trim().equalsIgnoreCase("Member")){
            new User(name,username,password,email,birthday, Role.MEMBER);
            //System.out.println(database.users.toString());
            return "Your registration was successful!";
        } else{
            new User(name,username,password,email,birthday, Role.ADMIN);
            //System.out.println(database.users.toString());
            return "Your registration was successful!";
        }

        //System.out.println(database.users.toString());


    }

    private static boolean checkPasswordRegex(String pass){
        String str = "^\\d{1,3}[A-Z]+[a-z]{3,7}$";

        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(pass);
        if(matcher.find()){
            return true;
        } else{
            return false;
        }
    }

    public String login(String username, String password) {
        User user = null;
        for (User user1 : User.getAllUsers().keySet()) {
            if(user1.getUsername().equals(username)){
                user = user1;
            }
        }
        if(user == null){
            return "There isn't any user with this username!";
        } else{
            if(!user.getPassword().equals(password)){
                return "Your password is incorrect";

            }
            LocalDateTime localDateTime = LocalDateTime.now();
            user.getLogs().add(localDateTime);
            User.getAllUsers().replace(user,true);

            return "You have successfully logged in";
        }

    }
}
