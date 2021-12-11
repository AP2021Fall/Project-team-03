package controller;

import model.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseController {

    private final Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public User getUser(String username) {
        for (User user : database.getUsers().keySet()) {
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }

    public String register(String username, String password, String birthday, String email, String roll) {
        for (User user : database.getUsers().keySet()) {
            if(user.getUsername().equals(username)){
                return "This username is already registered";
            }
        }
        if(!checkRegex(password)){
            return "Select the password in the following format";
        }

        if(roll.equalsIgnoreCase("Admin")){
            database.getUsers().put(new Admin(username,password,email,birthday) ,true);
        } else if(roll.equalsIgnoreCase("Leader")){
            database.getUsers().put(new Leader(username,password,email,birthday) ,true);
        }else if(roll.equalsIgnoreCase("Member")){
            database.getUsers().put(new Leader(username,password,email,birthday) ,true);
        } else{
            database.getUsers().put(new Leader(username,password,email,birthday) ,true);
        }

        System.out.println("Your registration was successful!");
        return "Your registration was successful!";

    }

    public boolean checkRegex(String input){
        String str = "^\\d{1,3}[A-Z]+[a-z]{3,7}$";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public String login(String username, String password) {
        User user = null;
        for (User user1 : database.getUsers().keySet()) {
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
            database.getUsers().replace(user,true);
            return "You have successfully logged in";
        }
    }

    //state ro moshakhas konim
    public void addUser(User user) {
        database.getUsers().put(user,true);
    }

    public Task getTask(String title) {
        for (Task task : database.getTasks()) {
            if (task.getTitle().equals(title))
                return task;
        }
        return null;
    }

    public void addTask(Task task) {
        // TODO:   task.setId(generateId(task));
        database.addTask(task);
    }

    public ArrayList<Task> getAllTasks() {
        return database.getTasks();
    }

    public ArrayList<Task> getUserTasks(User user) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : database.getTasks()) {
            if (task.getAssignee().equals(user))
                result.add(task);
        }
        return result;
    }

    public Task getTaskById(String id) {
        for (Task task : database.getTasks()) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public Task getTaskByTitle(String title) {
        for (Task task : database.getTasks()) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }
    public String generateId(Task task) {
        return String.valueOf(task.hashCode());
    }
}
