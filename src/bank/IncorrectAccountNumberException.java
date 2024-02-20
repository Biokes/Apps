package bank;

public class IncorrectAccountNumberException extends Throwable{
    public IncorrectAccountNumberException(String errorMessage){
        super(errorMessage);
    }
}
