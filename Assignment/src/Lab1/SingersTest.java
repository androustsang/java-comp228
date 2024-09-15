package Lab1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SingersTest {
    public static void main(String[] args) {
        Singers singer1 = new Singers();    // create the object with the constructor of no arguments
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM yyyy"); // define the date of birth display format

        // Display the default values
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
        singer1.setAllValues(2,
                "Celine Dion","Somewhere in Canada",
                LocalDate.of(1968,3,30),56);

        System.out.println("The value of singer1 id is changed to: " + singer1.getId());
        System.out.println("The value of singer1 name is changed to: " + singer1.getSingerName());
        System.out.println("The value of singer1 address is changed to: " + singer1.getSingerAddress());
        System.out.println("The value of singer1 date of birth is changed to: " + singer1.getDateOfBirth().format(dtf));
        System.out.println("The value of singer1 number of albums is changed to: " + singer1.getNumberOfAlbums());

    }
}
