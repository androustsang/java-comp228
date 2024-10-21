package Midterm_Practices;

// Exercise 1
public class Person {
    private String name;
    private int age;

    //Constructors with 2 arguments
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet () {
        System.out.printf("Hello, my name is %s, and I am %d years old\n", this.name, this.age);
    }
}
