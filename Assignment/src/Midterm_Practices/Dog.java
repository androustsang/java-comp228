package Midterm_Practices;

public class Dog extends Animal {

    public Dog() {
        super.name = "Dog";
    }

@Override
    public String makeSound() {
        return "Bark";
    }
}
