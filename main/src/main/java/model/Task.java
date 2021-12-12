package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {

    private static int id = 0;
    private String category;
    private String title;
    private String description;
    private Priority priority;
    private LocalDateTime creationDate;
    private LocalDateTime deadline;
    private ArrayList<User> assignedUsers;
    private ArrayList<String> assignedUserStates;


    public Task(String title, LocalDateTime creationDate, LocalDateTime deadline, String teamName) {
        this.id = generateId();
        this.title = title;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.description = null;
        this.priority = null;
        this.assignedUsers = new ArrayList<User>();
    }


    public void assignUserToTask(User user, String teamName, int taskId) {
        Task task = getTaskById(teamName, taskId);

        if (canBeAssigned(user)) {
            task.assignedUsers.add(user);
            task.assignedUserStates.add("To Do");
        }
    }


    public static Task getTaskById(int id) {
        for (Task task: allTasks)
            if (task.id == id)
                return task;
        return null;
    }

    public boolean canBeAssigned(User user) {
        if (user.getRole() == Role.LEADER || user.getRole() == Role.ADMIN)
            return false;
        if (isAssignedToTask(user))
            return false;
        return true;
    }

    public boolean isAssignedToTask(User user) {
        for (User assignedUser : assignedUsers)
            if (assignedUser.getUsername().equals(user.getUsername()))
                return true;
        return false;
    }


    private static int generateId() {
        ++id;
        return id - 1;
    }

    public void assignUserToTask(User user, String teamName, int taskId) {
        Task task = getTaskById(teamName, taskId);

        if (canBeAssigned(user)) {
            task.assignedUsers.add(user);
            task.assignedUserStates.add("To Do");
        }
    }

    public double getPercentDone() {
        int numUsers = assignedUserStates.size();
        if (numUsers == 0)
            return 0;
        int numDone = 0;
        for (String userState : assignedUserStates)
            if (userState.equals(DefaultCategories.DONE.toString()))
                ++numDone;

        return (double) numDone / numUsers * 100;
    }

}