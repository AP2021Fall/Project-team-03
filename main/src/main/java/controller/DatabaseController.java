package controller;

import model.Database;
import model.Task;
import model.User;

import java.util.ArrayList;

public class DatabaseController {

    private final Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public User getUser(String username) {
        for (User user : database.getUsers()) {
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        database.getUsers().add(user);
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
