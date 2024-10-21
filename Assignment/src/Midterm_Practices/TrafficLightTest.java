package Midterm_Practices;

public class TrafficLightTest {

    public static void main(String[] args) {
        for (TrafficLight color : TrafficLight.values()) {
            System.out.println(color + " Light - " + getMessage(color));
        }
    }

    public static String getMessage(TrafficLight color) {
        String message = "";

        switch (color) {
            case RED:
                message =  "Stop for " + color.getDuration() + " seconds";
                break;
            case YELLOW:
                message =  "Slow down for " + color.getDuration() + " seconds";
                break;
            case GREEN:
                message =  "Go for " + color.getDuration() + " seconds";
                break;
        }
        return message;

    }
}
