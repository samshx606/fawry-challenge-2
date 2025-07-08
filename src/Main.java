import config.AppStartUp;
import service.BookService;


public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        AppStartUp.run();
    }
}