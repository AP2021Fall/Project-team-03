package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreBoard {

    public static List<ScoreBoard> allScoreBoards=new ArrayList<>();

    private String teamName;
    private String memberUsername;
    private Integer memberScore;
    private HashMap<String, Integer> scoreBoardInfo= new HashMap<String, Integer>();


    public HashMap<String, Integer> getScoreBoardInfo() {
        return scoreBoardInfo;
    }
    public HashMap<String, Integer> getScoreBoardInfoByTeamName(String teamName) {
        return scoreBoardInfo;
    }


    public static List<ScoreBoard> getAllScoreBoards() {
        return allScoreBoards;
    }


    public String getMemberUsername() {
        return memberUsername;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getMemberScore() {
        return memberScore;
    }

    public void setScoreBoardInfo(HashMap<String, Integer> scoreBoardInfo) {
        this.scoreBoardInfo = scoreBoardInfo;
    }

}
