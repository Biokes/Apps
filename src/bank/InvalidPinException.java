package bank;

public class InvalidPinException extends IllegalArgumentException{
    public InvalidPinException(String message){
        super(message);
    }
}
