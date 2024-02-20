package bank;

public class InvalidAmountException extends Throwable{
    public InvalidAmountException(String errorMessage){
        super(errorMessage);
    }
}
