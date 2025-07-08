package entity;

import java.time.Year;

public class Book {
    private String title;
    private String isbn;
    private double price;
    private Year publicationYear;
    BookType bookType;

    public Book(String title, String isbn, double price, Year publicationYear, BookType bookType) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publicationYear) {
        this.publicationYear = publicationYear;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
