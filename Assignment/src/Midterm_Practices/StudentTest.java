package Midterm_Practices;

public class StudentTest {
    public static void main(String[] args) {
        double[] grades = new double[]{85.0,  90.5,  78.0};

//        System.out.printf("%.2f%n", grades);
        Student student = new Student("John", grades);
        Student student2 = new Student("Jane", new double[] {85.0, 90.5, 78.0});
        student.printGrades();
        student2.printGrades();

    }
}
