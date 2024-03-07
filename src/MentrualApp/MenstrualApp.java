package MentrualApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualApp {

    public boolean validateDate(String dateGiven) {
        try {
            LocalDate date = LocalDate.parse(dateGiven, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return date.isAfter(LocalDate.now());
        } catch (Exception error) {
            throw new InvalidDateException();
        }
    }
}
