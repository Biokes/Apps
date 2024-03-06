package diary;

import java.time.LocalDate;

public class Entry {
    private int id;
    private String body;
    private String title;
    private LocalDate dateCreated;

    public Entry(int idNumber, String title, String body) {
        this.body = body;
        this.id = idNumber;
        this.title= title;
        dateCreated = LocalDate.now();
    }

    public String getTitle() {

        return title;
    }

    public int getIdNumber() {

        return this.id;
    }
    public String toString(){
        return String.format("Entry ID: %s\nEntry Title: %s\nEntry Body: %s", id,title,body);
    }
}
