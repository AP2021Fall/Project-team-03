package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoadMap {
    //TO have a list of all members
    private static List<User> memberList =new ArrayList<>();
    public static Integer readMapID ;
    private String taskTitle ;
    private Integer percentage;
    private String dateOfTask;
    HashMap<String,Integer>taskPercentageDone =new HashMap<>();

    public HashMap<String, Integer> getTaskPercentageDoneInfo() {
        return taskPercentageDone;
    }

    public RoadMap(String taskTitle, Integer percentage) {
        this.taskTitle = taskTitle;
        this.percentage=percentage;
    }

    public static List<User> getMemberList() {
        return memberList;
    }
}
