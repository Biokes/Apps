package bank;

public class InsufficientBalanceException extends Throwable{
    public InsufficientBalanceException(String errorMessage){
        super(errorMessage);
    }

    public static class UserExistException extends RuntimeException{
        public UserExistException(){
            super("User Already Exist");
        }
    }
}
