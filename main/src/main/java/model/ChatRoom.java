package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ChatRoom {
    //TO have a list of all chatRooms
    private static List<ChatRoom> chatRoomList =new ArrayList<>();
    public static Integer chatRoomID;
    public String senderName;
    public String massageText;
    LinkedHashMap<String,String>allTeamMassages;

    public ChatRoom(String teamName) {
        this.teamName=teamName;
        this.allTeamMassages =new LinkedHashMap<>();
    }
    // private static List<Massage> massagesOfTheTeam = new ArrayList<>();

    private String teamName;
    //assign the name of the team from team class


    public static List<ChatRoom> getChatRoomList() {
        return chatRoomList;
    }
}

