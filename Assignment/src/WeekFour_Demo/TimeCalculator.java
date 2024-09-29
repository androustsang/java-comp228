package WeekFour_Demo;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class TimeCalculator {
    // Method to getcurrent local time using LocalDateTime

    public void getCurrentLocalDateTime() {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Current LocalDateTime: " + ldt);
    }
    // Method to get current time using ZonedDataTime
    public void getCurrentZonedDateTime() {

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zdt);
    }


    public static void main (String[] args) {
    TimeCalculator tc = new TimeCalculator();

    tc.getCurrentLocalDateTime();
    tc.getCurrentZonedDateTime();

    }
}

