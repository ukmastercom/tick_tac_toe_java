package org.example;

public class Board {
    private int dimension;
    private char[][] board;

    private int moves;
    public Board(int dimension){
        this.dimension = dimension;
        moves = 0;
        board = new char[dimension][dimension];
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                board[i][j] = '_';
            }
        }
    }

    public int getDimension(){
        return dimension;
    }

    public char[][] getBoard(){
        return board;
    }

    public boolean moveBoard(int row, int column, char move){
        if(row>=dimension || column>=dimension){
            return false;
        }
        if(board[row][column] == '_'){
            board[row][column] = move;
            moves++;
            return true;
        }
        return false;
    }

    public boolean isFilled(){
        if(moves==dimension*dimension){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i=0;i<dimension;i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0;j<dimension;j++){
                stringBuilder.append(board[i][j]);
            }
            System.out.println(stringBuilder.toString());
        }
    }


}
