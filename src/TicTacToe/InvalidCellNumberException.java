package TicTacToe;
public class InvalidCellNumberException extends RuntimeException{
    public InvalidCellNumberException(){
      super("Invalid Cell Number");
    }
}
