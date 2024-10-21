package Midterm_Practices;

public class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() {
        System.out.printf("Starting the " + type + " Engine ");
    }
}
