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
}
//    private LocalDate creationDate(){
//        String date = LocalDate.now().toString();
//        String[] date1 = date.split("-");
//        date1[0] = String.valueOf(Integer.parseInt(date1[0]));
//        date1[1] = String.valueOf(Integer.parseInt(date1[1]));
//        date1[2] = String.valueOf(Integer.parseInt(date1[2]));
//        date = String.format("%s-%s-%s",date1[0],date1[1],date1[2]);
//        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
//    }