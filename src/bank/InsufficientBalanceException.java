package bank;

public class InsufficientBalanceException extends Throwable{
    public InsufficientBalanceException(String errorMessage){
        super(errorMessage);
    }
}
