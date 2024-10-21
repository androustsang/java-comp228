package Midterm_Practices;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Student {
    private String name;
    private double[] grades;

    //Constructors
    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public double averageGrade() {
        double totalgrades = 0;
        for (int i = 0; i < grades.length; i++) {
            totalgrades += grades[i];
        }
        return totalgrades / (grades.length );
    }

    public void printGrades() {
        double avegrade = averageGrade();
        System.out.printf("Student Name: %s\n", name);
        System.out.printf("Student Grade: %s\n", Arrays.toString(grades));
        System.out.printf("Student Grade: ");
        for (double grade: grades) {
            System.out.printf("%.1f ", grade);
        }
        System.out.println();
        System.out.printf("The average grade is %.1f\n", avegrade);

    }
}
