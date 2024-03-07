package MentrualApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualApp {

    public boolean validateDate(String dateGiven) {
        LocalDate date = LocalDate.parse(dateGiven, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return date.isAfter(LocalDate.now());
    }
}
