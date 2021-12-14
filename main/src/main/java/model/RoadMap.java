package model;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class RoadMap {
    //TO have a list of all members
    private static List<User> memberList =new ArrayList<>();
    public static Integer readMapID ;
    private String taskTitle ;
    private Integer percentage;
    private String dateOfTask;

    public RoadMap(String taskTitle,Integer percentage) {
        this.taskTitle = taskTitle;
        this.percentage=percentage;
    }

    public static List<User> getMemberList() {
        return memberList;
    }
}