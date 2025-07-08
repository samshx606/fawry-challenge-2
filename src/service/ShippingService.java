package service;

import entity.PaperBook;

public class ShippingService {
    private PaperBook paperBook;
    public void sendBook(String address) {
        System.out.println("Shipping book to: " + address);
    }
}
