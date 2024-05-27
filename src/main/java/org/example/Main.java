package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Player readPlayerDetails(int turn){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        return new Player(inputs[1],inputs[0].charAt(0),turn);
    }

    public static void main(String[] args) {
        int sizeOfBoard = 3;
        int noOfPlayers = 2;
        List<Player> playerList = new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++){
            playerList.add(readPlayerDetails(0));
        }
        Board gameBoard = new Board(sizeOfBoard);
        Scanner scanner = new Scanner(System.in);
        boolean isGameOn = true;
        int turn = 0;
        gameBoard.printBoard();
        while (isGameOn){
            String[] positions = scanner.nextLine().split(" ");
            int row = Integer.parseInt(positions[0])-1;
            int column = Integer.parseInt(positions[1])-1;
            if(!RuleBook.isValidMove(gameBoard,row,column,playerList.get(turn).getMove())){
                System.out.println("Invalid Move!");
            }
            else{
                gameBoard.printBoard();
                if(RuleBook.checkIfPlayerWon(gameBoard)){
                    System.out.println(playerList.get(turn).getPlayerName() +" won the game");
                    isGameOn = false;
                }
                if(gameBoard.isFilled()){
                    System.out.println("GAME OVER");
                    isGameOn = false;
                }
                turn = (turn+1)%noOfPlayers;
            }
        }





    }
}