package diary;

public class DiaryNotFoundException extends RuntimeException {
    public DiaryNotFoundException(){
        super("Diary Not found.");
    }
}
