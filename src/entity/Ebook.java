package entity;

import java.time.Year;

public class Ebook extends Book {
    private String fileType;
    public Ebook(String title, String isbn, double price, Year publicationYear, String fileType) {
        super(title, isbn, price, publicationYear, BookType.EBOOK);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
