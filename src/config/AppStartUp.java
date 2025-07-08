package config;

import entity.Book;
import entity.DemoBook;
import entity.Ebook;
import entity.PaperBook;
import service.BookService;

import java.time.Year;

public class AppStartUp {
    public static void run() {
        BookService bookService = new BookService();
        PaperBook book1  = new PaperBook("One Piece", "9780062390486", 33.3, Year.of(2020), 10);
        PaperBook book2  = new PaperBook("Clean Code", "9780132350884", 45.0, Year.of(2008), 5);
//        Book book3  = new PaperBook("The Hobbit", "9780345339683", 29.5, Year.of(1937), 7);
//        Book book4  = new PaperBook("Java: A Beginner's Guide", "9781260440218", 39.0, Year.of(2018), 12);
//        Book book5  = new PaperBook("Harry Potter", "9780747532743", 28.0, Year.of(1997), 8);

        Ebook book6  = new Ebook("Effective Java", "9780134685991", 50.0, Year.of(2018), "PDF");
        Ebook book7  = new Ebook("Design Patterns", "9780201633610", 40.0, Year.of(1994), "EPUB");
//        Book book8  = new Ebook("Atomic Habits", "9780735211292", 25.0, Year.of(2018), "MOBI");
//        Book book9  = new Ebook("Refactoring",  "9780134757599", 42.0, Year.of(2019), "PDF");
//        Book book10 = new Ebook("You Don't Know JS",  "9781491904244", 30.0, Year.of(2015), "EPUB");

        DemoBook book11 = new DemoBook("Preview of Dune",  "0000000000000", 0.0, Year.of(1965));
        DemoBook book12 = new DemoBook("Machine Learning Preview",  "0000000000001", 0.0, Year.of(2021));
//        Book book13 = new DemoBook("Spring Boot In Action - Demo",  "0000000000002", 0.0, Year.of(2016));
//        Book book14 = new DemoBook("AI Revolution - Sample",  "0000000000003", 0.0, Year.of(2023));
//        Book book15 = new DemoBook("Game of Thrones Sampler",  "0000000000004", 0.0, Year.of(1996));

        bookService.addBook(book1);
        bookService.addBook(book2);
//        bookService.addBook(book3);
//        bookService.addBook(book4);
//        bookService.addBook(book5);
        bookService.addBook(book6);
        bookService.addBook(book7);
//        bookService.addBook(book8);
//        bookService.addBook(book9);
//        bookService.addBook(book10);
        bookService.addBook(book11);
        bookService.addBook(book12);
//        bookService.addBook(book13);
//        bookService.addBook(book14);
//        bookService.addBook(book15);



        System.out.println("\nApp Startup Complete.\n\n");
        // -----------------------
        // view all books
        bookService.viewAllBooks();


        // buy PaperBook
        System.out.println("\n\nBuying PaperBook: " + book1.getTitle());
        System.out.println("Stock available before buying: " + book1.getStock());
        double price = bookService.buyBook(book1, "Shebin El Kom", 2);
        System.out.println( "Amount paid = " + price + " USD");
        System.out.println("Stock available after buying: " + book1.getStock());


//         test insufficient stock
         try {
             System.out.println("\n\nBuying PaperBook: " + book2.getTitle());
             price = bookService.buyBook(book2, "Shebin El Kom", 10);
             System.out.println( "Amount paid = " + price + " USD");
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

        // buy Ebook
        System.out.println("\n\nBuying Ebook: " + book6.getTitle());
        price = bookService.buyBook(book6, "saaameh.0.1@gmail.com");
        System.out.println( "Amount paid = " + price + " USD");


        // buy DemoBook

         try {
             System.out.println("\n\nBuying DemoBook: " + book11.getTitle());
             price = bookService.buyBook(book11, "Shebin El Kom", 3);
             System.out.println( "Amount paid = " + price + " USD");
         }catch (Exception e) {
             System.out.println(e.getMessage());
         }


        //  delete outdated books
        bookService.removeOutdatedBooks(7);
        System.out.println("\n\nBooks after removal:\n");
        bookService.viewAllBooks();
    }
}
