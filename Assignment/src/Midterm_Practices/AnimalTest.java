package Midterm_Practices;

import javax.xml.catalog.Catalog;

public class AnimalTest {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        System.out.println(dog.name + "'s Sound: " + dog.makeSound());
        System.out.println(cat.name + "'s Sound: " + cat.makeSound());

    }
}
