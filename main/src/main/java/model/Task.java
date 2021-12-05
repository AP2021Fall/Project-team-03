package model;

import java.time.LocalDateTime;

public class Task {
    private String id;
    private String title;
    private User assignee;
    private LocalDateTime deadline;
    private static ArrayList<Task> tasks = new ArrayList<>();

    public Task(String title) {
        generateId();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
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
            int lastId = tasks.get(lastInd);
            this.id = lastId + 1;
        }
    }

    public boolean changeTitle(int id, String title){
        tasks.for
    }

    public boolean changeDescription(int id, String title){

    }


    @Override
    public String toString() {
        return id + " " + title;
    }

}
