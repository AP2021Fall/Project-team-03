package com.example.project03withfx.model;

import java.util.HashMap;


        import java.util.ArrayList;
        import java.util.HashMap;

public class Database {
    public static HashMap<User, Boolean> users;
    //private static ArrayList<Task> tasks;

    {
        this.users = new HashMap<User, Boolean>();
        //this.tasks = new ArrayList<>();
    }

    public static HashMap<User, Boolean> getUsers() {
        return users;
    }
//    public static ArrayList<Task> getTasks() {
//        return tasks;
//    }

    public void addUser(User user) {
        if (!users.containsKey(user))
            users.put(user,true);
    }

    public boolean isPasswordCorrect(String password) {
        return this.isPasswordCorrect(password);
    }

    public static User getUserById(int id) {
        for (User user : users.keySet()) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }


    public static User getUserByUsername(String username) {
        for (User user : users.keySet()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

//    public static boolean userExists(String username) {
//        for (User user : users.keySet()) {
//            if (user.getUsername().equals(username)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean emailExists(String email) {
        for (User user : users.keySet()) {
            if (user.getUsername().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean userExists(String username) {
        for (User user : users.keySet()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


//    public void addTask(Task task) {
//        if (!tasks.contains(task))
//            tasks.add(task);
//    }
}
