package model;

import java.time.LocalDateTime;

public class Task {
    private String id;
    private String title;
    private User assignee;
    private LocalDateTime deadline;
    private String leader;
    private String proiority;

    public Task(String title) {
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



    public LocalDateTime getDeadline() {
        return deadline;
    }



    @Override
    public String toString() {
        return id + " " + title;
    }

}
