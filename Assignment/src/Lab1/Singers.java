package Lab1;
import java.time.LocalDate;

public class Singers {

    private int id; //Singer's id
    private String singerName; //Singer's name
    private String singerAddress; //Singer's address
    private LocalDate dateOfBirth; //Date of Birth
    private int numberOfAlbums; //Number of albums published

    //
    // user-defined constructors
    //

    // constructors with no arguments
    public Singers() {
        this.id = 0; //initialize to 0
        this.singerName = ""; //initialize to empty String
        this.singerAddress = ""; //initialize to empty String
        this.dateOfBirth = LocalDate.of(2999,1,1); // initialize to a future date
        this.numberOfAlbums = 0; // initialize to 0
    }

    //constructors with 1 argument
    public Singers(int id) {
        this.id = id;
        this.singerName = ""; //initialize to empty String
        this.singerAddress = ""; //initialize to empty String
        this.dateOfBirth = LocalDate.of(2999,1,1); // initialize to a future date
        this.numberOfAlbums = 0; // initialize to 0
    }

    //constructors with 2 arguments
    public Singers(int id, String singerName) {
        this.id = id;
        this.singerName = singerName;
        this.singerAddress = ""; //initialize to empty String
        this.dateOfBirth = LocalDate.of(2999,1,1); // initialize to a future date
        this.numberOfAlbums = 0; // initialize to 0
    }

    //constructors with 3 arguments
    public Singers(int id, String singerName, String singerAddress) {
        this.id = id;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = LocalDate.of(2999,1,1); // initialize to a future date
        this.numberOfAlbums = 0; // initialize to 0
    }

    //constructors with 4 arguments
    public Singers(int id, String singerName, String singerAddress, LocalDate dateOfBirth) {
        this.id = id;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = 0; // initialize to 0
    }

    //constructors with 5 arguments
    public Singers(int id, String singerName, String singerAddress, LocalDate dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }
    //
    // end of user-defined constructors
    //

    //
    // getters for all 5 instance variables
    //

    // getters for id
    public int getId() {
        return id;
    }

    // getters for singerName
    public String getSingerName() {
        return singerName;
    }

    // getters for singerAddress
    public String getSingerAddress() {
        return singerAddress;
    }

    // getters for dateOfBirth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // getters for numberOfAlbums
    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }
    //
    // end of getters
    //

    //
    // setters
    //

    // setters for setting all values of instance variables at once
    public void setAllValues(int id, String singerName, String singerAddress, LocalDate dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    // setters for each individual instance variable
    // setters for id
    public void setId(int id) {
        this.id = id;
    }

    // setters for singerName
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    // setters for singerAddress
    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    // setters for dateOfBirth
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // setters for numberOfAlbums
    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    //
    // end of setters
    //

}

