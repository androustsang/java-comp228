package Lab1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Driver Class

public class SingersTest {
    public static void main(String[] args) {

        Singers singer1 = new Singers();    // create the object with the constructor of no arguments
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM yyyy"); // define the date of birth display format

        // Display the default values
        System.out.println("singer1 is created with the constructor of no arguments");
        System.out.println("The default value of singer1 id is: " + singer1.getId()); // the + acts as concatenation so the integer is converted to string
        System.out.println("The default value of singer1 name is: " + singer1.getSingerName());
        System.out.println("The default value of singer1 address is: " + singer1.getSingerAddress());
        System.out.println("The default value of singer1 date of birth is: " + singer1.getDateOfBirth().format(dtf));
        System.out.println("The default value of singer1 number of albums is: " + singer1.getNumberOfAlbums()); // the + acts as concatenation so the integer is converted to string
        System.out.println();

        System.out.println("Now each instance variable of singer1 is modified.");

        singer1.setId(1);
        System.out.println("The value of singer1 id is changed to: " + singer1.getId());

        singer1.setSingerName("Taylor Swift");
        System.out.println("The value of singer1 name is changed to: " + singer1.getSingerName());

        singer1.setSingerAddress("Somewhere in USA");
        System.out.println("The value of singer1 address is changed to: " + singer1.getSingerAddress());

        singer1.setDateOfBirth(LocalDate.of(1989,12,13));
        System.out.println("The value of singer1 date of birth is changed to: " + singer1.getDateOfBirth().format(dtf));

        singer1.setNumberOfAlbums(57);
        System.out.println("The value of singer1 number of albums is changed to: " + singer1.getNumberOfAlbums());
        System.out.println();

        // Now we change all instance variables at once
        System.out.println("Now all instance variables of singer1 are modified at once.");
        singer1.setAllValues(99,
                "Celine Dion","Somewhere in Canada",
                LocalDate.of(1968,3,30),56);

        System.out.println("The value of singer1 id is changed to: " + singer1.getId());
        System.out.println("The value of singer1 name is changed to: " + singer1.getSingerName());
        System.out.println("The value of singer1 address is changed to: " + singer1.getSingerAddress());
        System.out.println("The value of singer1 date of birth is changed to: " + singer1.getDateOfBirth().format(dtf));
        System.out.println("The value of singer1 number of albums is changed to: " + singer1.getNumberOfAlbums());

        // Now create other objects with different constructors
        System.out.println();
        Singers singer2 = new Singers(2);
        System.out.println("Other constructors are used for creating additional objects.");
        System.out.println("The default value of singer2 is as follows with constructor of 1 argument.");
        System.out.println("id is: " + singer2.getId());
        System.out.println("Singer name is: " + singer2.getSingerName());
        System.out.println("Singer address is: " + singer2.getSingerAddress());
        System.out.println("Date of birth is: " + singer2.getDateOfBirth().format(dtf));
        System.out.println("Number of albums is: " + singer2.getNumberOfAlbums());

        System.out.println();
        Singers singer3 = new Singers(3,"Singer 3");
        System.out.println("The default value of singer3 is as follows with constructor of 2 arguments.");
        System.out.println("id is: " + singer3.getId());
        System.out.println("Singer name is: " + singer3.getSingerName());
        System.out.println("Singer address is: " + singer3.getSingerAddress());
        System.out.println("Date of birth is: " + singer3.getDateOfBirth().format(dtf));
        System.out.println("Number of albums is: " + singer3.getNumberOfAlbums());

        System.out.println();
        Singers singer4 = new Singers(4,"Singer 4","Somewhere out there");
        System.out.println("The default value of singer4 is as follows with constructor of 3 arguments.");
        System.out.println("id is: " + singer4.getId());
        System.out.println("Singer name is: " + singer4.getSingerName());
        System.out.println("Singer address is: " + singer4.getSingerAddress());
        System.out.println("Date of birth is: " + singer4.getDateOfBirth().format(dtf));
        System.out.println("Number of albums is: " + singer4.getNumberOfAlbums());

        System.out.println();
        Singers singer5 = new Singers(5,"Singer 5","Somewhere out there 5",LocalDate.of(1995,6,1));
        System.out.println("The default value of singer5 is as follows with constructor of 4 arguments.");
        System.out.println("id is: " + singer5.getId());
        System.out.println("Singer name is: " + singer5.getSingerName());
        System.out.println("Singer address is: " + singer5.getSingerAddress());
        System.out.println("Date of birth is: " + singer5.getDateOfBirth().format(dtf));
        System.out.println("Number of albums is: " + singer5.getNumberOfAlbums());

        System.out.println();
        Singers singer6 = new Singers(6,"Singer 6","Somewhere out there 6",LocalDate.of(1997,9,1),20);
        System.out.println("The default value of singer6 is as follows with constructor of 5 arguments.");
        System.out.println("id is: " + singer6.getId());
        System.out.println("Singer name is: " + singer6.getSingerName());
        System.out.println("Singer address is: " + singer6.getSingerAddress());
        System.out.println("Date of birth is: " + singer6.getDateOfBirth().format(dtf));
        System.out.println("Number of albums is: " + singer6.getNumberOfAlbums());

    }

}
