package MentrualApp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MenstrualApp {
    private LocalDate lastFlowStop;
    private LocalDate nextFlowStart;
    public boolean validateDate(String dateGiven) {
        try {
            LocalDate date = LocalDate.parse(dateGiven, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return date.isAfter(LocalDate.now());
        } catch (Exception error) {
            throw new InvalidDateException();
        }
    }
    private LocalDate convertDate(String day) {
        if (validateDate(day))
            return LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return null;
    }
    public String getNextStart(String lastDayEnded, int intervalsDate) {
        nextFlowStart = convertDate(lastDayEnded).plusDays(intervalsDate);
        nextFlowStart = nextFlowStart.plusDays(intervalsDate);
        return nextFlowStart.toString();
    }
    public void setLastFlowStop(String date) {
        lastFlowStop = convertDate(date);
    }
}
