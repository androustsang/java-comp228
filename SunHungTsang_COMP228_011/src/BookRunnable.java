// Driver class

import java.util.Scanner;

public class BookRunnable {

    public static void main(String[] args) {

        // For-loop is just to run twice for the user input
        // One for science book and one for children book
        for (int i = 0; i < 2; i++) {
            Book bookByUser = showInputDialog();
            showMessageDialog(bookByUser);
        }
    }

    public static Book showInputDialog() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the Genre as \"S\" for Science and \"C\" as Children: ");
        String genre = input.nextLine();

        while (!genre.equals("S") && !genre.equals("C")) {
            System.out.print("Please enter a valid Genre: ");
            genre = input.nextLine();
        }

        System.out.print("Enter title: ");
        String title = input.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        System.out.print("Enter publisher: ");
        String publisher = input.nextLine();

        System.out.print("Enter year: ");
        int year = input.nextInt();

        System.out.print("Enter price: ");
        double price = input.nextDouble();

        if (genre.equals("S")) {
            return new ScienceBook(title, isbn, publisher, year, price);
        } else if (genre.equals("C")) {
            return new ChildrenBook(title, isbn, publisher, year, price);
        }
        return null;
    }

    public static void showMessageDialog(Book book) {
        System.out.println();
        System.out.println("This is the book infomration.");
        System.out.println();
        System.out.printf("Genre: %s, %s%n", book.getGenre(), book.toString());
        System.out.println();

    }
}
