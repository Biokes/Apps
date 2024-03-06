package fireDrill1.fireDrill2;

public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException(){
        super("Invalid number provided");
    }
}
