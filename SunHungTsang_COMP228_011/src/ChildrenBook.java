public class ChildrenBook extends Book {

    private final String genre="Children";

    public ChildrenBook(String title, String isbn, String publisher, int year, double price) {
        super(title, isbn, publisher, year);
        this.setPrice(price);
    }

    @Override
    public void setPrice(double price) {
        this.price = price  ; // Fixed price with no discount for children books
    }

    @Override
    public String getGenre() {
        return genre;
    }

}
