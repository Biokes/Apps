package TicTacToe;

import fireDrill1.fireDrill2.InvalidNumberException;

import static TicTacToe.CellDisplays.*;
import static diary.DiaryMain.print;

public class GameBoard {
    private int count =0;
    private  Enum[][] board = {{EMPTY,EMPTY,EMPTY},{EMPTY,EMPTY,EMPTY},{EMPTY,EMPTY,EMPTY}};
    private Player player1 = new Player("player one");
    private Player player2  = new Player("player two");
    public Enum checkCell(int given) {
        validateNumber(given);
        int line = --given /3;
        int position = given %3;
        return board[line][position];
    }
    private  void validateNumber(int number){
        if (number < 1 || number > 9)
            throw new InvalidCellNumberException();
    }
    public void play(int given) {
        if(checkCell(given) == EMPTY) {
            if (count % 2 == 0) {
                changeCellValueForX(given);
            } else {
                changeCellValueForO(given);
            }
            count++;
            return;
        }
        throw new CellOccupiedException();
    }
    private void changeCellValueForX(int given){
        int line = --given /3;
        int position = given %3;
        board[line][position] = X;
    }
    private void changeCellValueForO(int cellNumber){
        int row = --cellNumber /3;
        int column = cellNumber %3;
        board[row][column] = O;
    }
    public String result(){
        if(count ==9 )
            return "Draw";
        else if(
        (board[0][0] == X && board[0][1] == X && board[0][2] == X) ||
        (board[1][0] == X && board[1][1] == X && board[1][2] == X) ||
        (board[2][0] == X && board[2][1] == X && board[2][2] == X) ||
        (board[0][0] == X && board[1][0] == X && board[2][0] == X) ||
        (board[0][1] == X && board[1][1] == X && board[2][1] == X) ||
        (board[0][2] == X && board[1][2] == X && board[2][2] == X) ||
        (board[0][0] == X && board[1][1] == X && board[2][2] == X) ||
        (board[2][0] == X && board[1][1] == X && board[0][2] == X))
            return "Player 1 wins.";
        else if(
        (board[0][0] == O && board[0][1] == O && board[0][2] == O) ||
        (board[0][1] == O && board[1][1] == O && board[2][1] == O) ||
        (board[0][2] == O && board[1][2] == O && board[2][2] == O) ||
        (board[0][0] == O && board[1][0] == O && board[2][0] == O) ||
        (board[1][0] == O && board[1][1] == O && board[1][2] == O) ||
        (board[2][0] == O && board[2][1] == O && board[2][2] == O) ||
        (board[0][0] == O && board[1][1] == O && board[2][2] == O) ||
        (board[2][0] == O && board[1][1] == O && board[0][2] == O))
        return "Player 2 wins.";
        return "";
    }
    public  String printBoard(){
        String output = String.format("%s %s %s %s %s %s %s\n","-","-","-","-","-","-","-");
        for(int row = 0; row < 3;row++){
            for(int column = 0; column < 3; column++) {
                if (board[row][column] == EMPTY)
                    output += String.format("%s %s", " ", " | ");
                else
                    output += String.format("%s %s", board[row][column], " | ");
            }
            output += String.format("\n%s %s %s %s %s %s %s\n","-","-","-","-","-","-","-");
        }
        return output;
    }
    public void player1Game(){
        try {
            play(player1.playGame());
            printBoard();
        }catch (InvalidCellNumberException | CellOccupiedException | InvalidNumberException exception){
            System.out.println(exception.getMessage());
            play(player1.playGame());
        }
        printBoard();
    }
    public void player2Game(){
        try {
            play(player2.playGame());
            printBoard();
        }catch (InvalidCellNumberException | InvalidNumberException exception){
            System.out.println(exception.getMessage());
            player2Game();
        }
    }
    public void game(){
        System.out.println(printBoard());
        for(int counter = 0; counter < 5; counter++){
            player1Game();
            System.out.println(printBoard());
            if(result() != "" || result() ==  "Draw") {
                System.out.println(printBoard());
                System.out.println((result()));
               break;
            }
            player2Game();
            System.out.println(printBoard());
            if(!result().equals("")) {
                System.out.println((result()));
                break;
            }
        }

    }
}
