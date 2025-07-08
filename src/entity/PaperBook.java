package entity;

import java.time.Year;

public class PaperBook extends Book {
    private int stock;
    public PaperBook(String title, String isbn, double price, Year publicationYear, int stock) {
        super(title, isbn, price, publicationYear, BookType.PAPER);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
