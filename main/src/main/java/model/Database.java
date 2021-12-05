package model;

import java.util.ArrayList;

public class Database {
    private final ArrayList<User> users;
    private final ArrayList<Task> tasks;

    {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
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
