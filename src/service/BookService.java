package service;

import entity.Book;
import entity.BookType;
import entity.PaperBook;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;


public class BookService {
    private Set<Book> bookInventory;
    final private ShippingService shippingService;
    final private MailService mailService;
    public BookService() {
        this.bookInventory = new HashSet<>();
        this.shippingService = new ShippingService();
        this.mailService = new MailService();
    }

    public Set<Book> getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(Set<Book> bookInventory) {
        this.bookInventory = bookInventory;
    }
    public void viewAllBooks() {
        if (bookInventory.isEmpty()) {
            System.out.println("No books available in inventory.");
        } else {
            System.out.println("Books in inventory:\n");
            for (Book book : bookInventory) {
                System.out.println(book.getTitle() + " - " + book.getPublicationYear());
            }
        }
    }
    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book cannot be null.");
        if (bookInventory.contains(book))
            throw new IllegalArgumentException("Book already exists in inventory.");
        bookInventory.add(book);
    }
    public void removeOutdatedBooks(int years) {
        if (years < 0)
            throw new IllegalArgumentException("Years cannot be negative.");
        Year currentYear = Year.now();
        bookInventory.removeIf(book -> book.getPublicationYear().isBefore(currentYear.minusYears(years)));
    }
    // Ebook
    public double buyBook(Book book, String Email) {
        if (book == null)
            throw new IllegalArgumentException("Book cannot be null.");
        if (!bookInventory.contains(book))
            throw new IllegalArgumentException("Book not found in inventory.");
        mailService.sendEbook(Email);
        return book.getPrice();
    }
    // PaperBook or DemoBook
    public double buyBook(Book book, String address, int quantity) {
        if (book == null)
            throw new IllegalArgumentException("Book cannot be null.");
        if (!bookInventory.contains(book))
            throw new IllegalArgumentException("Book not found in inventory.");
        if(book.getBookType().equals(BookType.DEMO))
            throw new IllegalArgumentException("Demo books cannot be purchased.");
        if(((PaperBook)book).getStock() < quantity)
            throw new IllegalArgumentException("Insufficient stock for the book: " + book.getTitle());
        shippingService.sendBook(address);
        ((PaperBook)book).setStock(((PaperBook) book).getStock() - quantity);
        return book.getPrice() * quantity;
    }
}
