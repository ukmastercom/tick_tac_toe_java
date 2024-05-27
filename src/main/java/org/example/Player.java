package org.example;

public class Player {
    private String playerName;
    private char move;
    private int turn;

    public Player(String playerName, char move, int turn){
        this.playerName = playerName;
        this.move = move;
        this.turn = turn;
    }

    public char getMove(){
        return move;
    }

    public String getPlayerName(){
        return playerName;
    }

}
