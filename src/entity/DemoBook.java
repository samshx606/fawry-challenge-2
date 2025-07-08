package entity;

import java.time.Year;

public class DemoBook extends Book {
    public DemoBook(String title, String isbn, double price, Year publicationYear) {
        super(title, isbn, price, publicationYear, BookType.DEMO);
    }
}
