public class ScienceBook extends Book {

    private final String genre="Science";
    private double discount = 0.9;

    public ScienceBook(String title, String isbn, String publisher, int year, double price) {
        super(title, isbn, publisher, year);
        this.setPrice(price);
    }

    @Override
    public void setPrice(double price) {
        this.price = price * discount ; // 10% discount for science books
    }

    @Override
    public String getGenre() {
        return genre;
    }

}
