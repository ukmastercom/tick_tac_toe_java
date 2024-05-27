package org.example;

public class RuleBook {

    private static boolean checkCondition1(Board gameBoard){
        for(int i=0;i<gameBoard.getDimension();i++){
            char ch = gameBoard.getBoard()[i][0];
            if(ch=='_')continue;
            for(int j=1;j<gameBoard.getDimension();j++) {
                if (ch != gameBoard.getBoard()[i][j]) {
                    break;
                } else if (j == gameBoard.getDimension() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCondition2(Board gameBoard){
        for(int j=0;j<gameBoard.getDimension();j++){
            char ch = gameBoard.getBoard()[0][j];
            if(ch=='_')continue;
            for(int i=1;i<gameBoard.getDimension();i++){
                if(ch!=gameBoard.getBoard()[i][j]){
                    break;
                }
                else if(i==gameBoard.getDimension()-1){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCondition3(Board gameBoard){
        char ch = gameBoard.getBoard()[0][0];
        if(ch!='_') {
            for (int i = 0; i < gameBoard.getDimension(); i++) {
                if (gameBoard.getBoard()[i][i] != ch) {
                    break;
                } else {
                    if (i == gameBoard.getDimension() - 1) {
                        return true;
                    }
                }
            }
        }

        ch = gameBoard.getBoard()[0][gameBoard.getDimension()-1];
        if(ch!='_') {
            for (int i = 0; i < gameBoard.getDimension(); i++) {
                if (gameBoard.getBoard()[i][gameBoard.getDimension() - i - 1] != ch) {
                    break;
                } else {
                    if (i == gameBoard.getDimension() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkIfPlayerWon(Board gameBoard){
        if(checkCondition1(gameBoard) || checkCondition2(gameBoard) || checkCondition3(gameBoard)){
            return true;
        }
        return false;
    }

    public static boolean isValidMove(Board gameBoard, int row, int column, char move){
        boolean isValid = gameBoard.moveBoard(row,column,move);
        if(isValid){
            return true;
        }
        return false;
    }
}
