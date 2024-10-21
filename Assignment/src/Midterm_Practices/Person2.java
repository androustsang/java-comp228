package Midterm_Practices;

public class Person2 {
    protected String name;
    protected int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void  displayInfo() {
//        System.out.printf("Name: %s\nAge: %d\n", name, age);;
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

}
