package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static HashMap<User,Boolean> users;
    private final ArrayList<Task> tasks;

    {
        users = new HashMap<User,Boolean>();
        tasks = new ArrayList<>();
    }

    public static HashMap<User,Boolean> getUsers() {
        return users;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addUser(User user) {
        if (!users.contains(user))
            users.add(user);
    }



    public void addTask(Task task) {
        if (!tasks.contains(task))
            tasks.add(task);
    }
}
