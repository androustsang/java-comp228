package Midterm_Practices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String getFormattedDate() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        // Consider the following suggested solution
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(formatter);

    }
    public static String getFormattedTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
