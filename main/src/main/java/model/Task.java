package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
//comment ro nazadam
public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDateTime creation;
    private LocalDateTime deadline;
    private ArrayList<User> assignedUsers;
    private static ArrayList<Task> tasks = new ArrayList<>();
    private Priority priority;

    //constructor form : String title, Priority priority, LocalDateTime deadLine
    //beporsam?????
    public Task(String title, Priority priority, LocalDateTime deadLine) {
        generateId();
        this.title = title;
        this.priority = priority;
        this.creation = LocalDateTime.now();
        this.deadline = deadLine;
        this.assignedUsers = new ArrayList<>();
        tasks.add(this);
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<User> getAssignedUsers() {
        return assignedUsers;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    private void generateId(){
        if(tasks.isEmpty()){
            this.id = 1;
        } else{
            int lastInd = tasks.size() - 1;
            int lastId = tasks.get(lastInd).getId();
            this.id = lastId + 1;
        }
    }

    public boolean changeTitle(int id, String title){

        for (Task t : tasks) {
            if(t.getId() == id){
                t.title = title;
                return true;
            }
        }
        return false;

    }

    public boolean changeDescription(int id, String description){

        for (Task t : tasks) {
            if(t.getId() == id){
                t.description = description;
                return true;
            }
        }
        return false;
    }

    public boolean changePriority(int id, Priority priority){

        for (Task t : tasks) {
            if(t.getId() == id){
                t.priority = priority;
                return true;
            }
        }
        return false;
    }

    public boolean changeDeadline(int id, String time){

        try {
            LocalDateTime deadline = LocalDateTime.parse(time);
        } catch (Exception e) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        for (Task t : tasks) {
            if(t.getId() == id){
                if(deadline.isAfter(now) && deadline.isAfter(t.creation)){
                    t.deadline = deadline;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeAssignedUser(int id, String username){
        User user = null;
        Task task = null;
        for (Task t : tasks) {
            if(t.getId() == id){
                task = t;
                for (User assignedUser : t.getAssignedUsers()) {
                    if(assignedUser.getUsername().equals(username)){
                       user = assignedUser;
                    }
                }
            }

        }
        if(user != null){
           task.getAssignedUsers().remove(user);
           return true;
        }
        return false;
    }

    public boolean addAsignedUser(int id, String username){
        User user = null;
        for (User user1 : User.getUsers()) {
            if(user1.getUsername().equals(username)){
                user = user1;
            }
        }
        if(user != null){
            for (Task t : tasks) {
                if(t.getId() == id){
                    t.getAssignedUsers().add(user);
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Task Id:\t" + id + "\n" +
                "Task Title:\t" + title + "\n" +
                "Task Description:\t" + description + "\n" +
                "Task Priority:\t" + priority + "\n" +
                "Task Title:\t" + title + "\n" +
                "Date and time of creation:\t" + creation + "\n" +
                "Date and time of deadline:\t" + deadline + "\n" +
                "Assigned Users:\t" + assignedUsers + "\n" +
                "Comments:\n";
    }

}
