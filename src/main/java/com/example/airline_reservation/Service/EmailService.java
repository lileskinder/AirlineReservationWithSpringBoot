package com.example.airline_reservation.Service;

public interface EmailService {
    public void sendEmail(String to, String subject, String text);
}
