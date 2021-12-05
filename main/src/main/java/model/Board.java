package model;

import java.util.ArrayList;

public class Board {
    private String name;
    //private Leader leader;
    private BoardState state;
    private static ArrayList<Board> boards = new ArrayList<>();
    private ArrayList<Task> doneTasks;
    private ArrayList<Task> failedTasks;

    public Board(String name) {
        this.name = name;
        this.state = BoardState.ELEMENTAL;

        boards.add(this);
        this.doneTasks = new ArrayList<>();
        this.failedTasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Board> getBoards() {
        return boards;
    }

    public boolean addBoard(String name){
        Board board = null;
        for (Board board1 : boards) {
            if(board1.getName().equals(name)){
                board = board1;
            }
        }
        if(board == null){
            new Board(name);
            return true;
        }
        return false;
    }
    public boolean removeBoard(String name){
        Board board = null;
        for (Board b : Board.getBoards()) {
            if(b.getName().equals(name)){
                board = b;
            }
        }

        if(board != null){
            Board.getBoards().remove(board);
            return true;
        }
        return false;
    }

}
