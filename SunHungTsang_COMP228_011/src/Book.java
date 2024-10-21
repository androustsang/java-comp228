// Abstract Class of Book

public abstract class Book {
    String title;
    String isbn;
    String publisher;
    double price;
    int year;

    @Override
    public String toString() {
        return String.format("Title: %s, ISBN: %s, Publisher: %s, Price: %.2f, Year: %d", title, isbn, publisher, price, year);
    }

    // Constructors
    public Book(String title, String isbn, String publisher, int year) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.price = 0.0;
    }

    // Getters for all instance variables except price
    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    // Setters for all instance variables except price
    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void setPrice(double price) ;
    public abstract String getGenre();

}
