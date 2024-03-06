package diary;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    public Diary(String name,String password){
        this.userName = name;
        this.password = password;
    }
    private final String userName;
    private final String password;
    private boolean isLocked;
    private Entry entry;
    private List<Entry> listOfEntries = new ArrayList<>();
    public String checkUserName() {

        return userName;
    }
    public boolean isCorrect(String password){
        return this.password.equals(password);

    }

    String getPassword() {

        return this.password;
    }

    public boolean isLocked(){

        return isLocked;
    }

    public void unlockDiary(String password) {
        if(this.password.toLowerCase().equals(password.toLowerCase())){
            isLocked= false;
        }
    }

    public String createEntry(String title, String body){
            Entry entry = new Entry(1+listOfEntries.size(), title,body);
            listOfEntries.add(entry);
            return entry.toString();
    }

    public Entry findEntryById(int idNumber){
        if(!isLocked){
        for(Entry entry: listOfEntries){
            if(entry.getIdNumber() == idNumber)
                return entry;
        }
        throw new InvalidUserException();
        }
        throw new IncorrectPasswordException();
    }

    public String updateEntry(int entryId, String title, String body){
        if(!isLocked)
            for(Entry entry : listOfEntries){
                if(entry.getIdNumber() == entryId) {
                    entry = new Entry(entryId, title, body);
                    return entry.toString();
                }
            }
        throw new InvalidUserException();

    }

    public int entrySize(){

        return listOfEntries.size();
    }

    public void lockDiary() {

        isLocked = true;
    }
    @Override
    public String toString(){

        return String.format("UserName : %s\nNumber of enteries: %s",userName,listOfEntries.size());
    }

    public void deleteEntry(int id) {
        for(Entry entry : listOfEntries){
            if(entry.getIdNumber() == id ){
                listOfEntries.remove(entry);
                return;
            }
        }
        throw new InvalidUserException();
    }
}
