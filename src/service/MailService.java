package service;

import entity.Ebook;

public class MailService {
    private Ebook ebook;
    public void sendEbook(String email) {
        System.out.println("Sending ebook to: " + email);
    }
}
