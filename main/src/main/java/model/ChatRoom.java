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
    LinkedHashMap<String,String>allTeamMassages= new LinkedHashMap<>();

    public LinkedHashMap<String, String> getAllTeamMassages() {
        return allTeamMassages;
    }

    private String teamName;

    public static List<ChatRoom> getChatRoomList() {
        return chatRoomList;
    }
}
