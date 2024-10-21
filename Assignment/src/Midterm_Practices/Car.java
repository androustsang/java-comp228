package Midterm_Practices;


public class Car {
    private String model;
    private final Engine engine;

//    public Car() {
//        this.model = "Telsa Model S";
//        this.engine = new Engine("Electric");
//    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        this.engine.start();
        System.out.printf("of " + model + "...");
    }

    public static void main(String[] args) {
        Engine electricengine = new Engine("Super Electric");
        Car telsa = new Car("Tesla Model Y", electricengine);

        Car car = new Car("Telsa Model S", new Engine("Electric"));
        car.startCar();

        telsa.startCar();
    }
}
