package diary;


import bank.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<>();

    public void  add(String username, String password) {
        try {
            if (findByUserName(username).isCorrect(password)) {
                throw new InsufficientBalanceException.UserExistException();
            }
        }catch(DiaryNotFoundException diaryNotFoundException) {
            Diary diary = new Diary(username, password);
            diaries.add(diary);
        }
    }
    public void add(Diary diary){
        String name = diary.checkUserName();
        String password = diary.getPassword();
        add(name, password);
    }


    public int checkNumberOfDiaries() {

        return diaries.size();
    }

    public Diary findByUserName(String userName) {
        for (Diary diary : diaries) {
            if (diary.checkUserName().equals(userName)) {
                return diary;
            }
        }
        throw new DiaryNotFoundException();
    }

    public void delete(String userName, String password) {
        if (findByUserName(userName).isCorrect(password)) {
            diaries.remove(findByUserName(userName));
            return;
        }
        throw new IncorrectPasswordException();
    }


}