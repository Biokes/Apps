package diary;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(){
        super("Invalid id provided.");
    }
}
