package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.Implementation.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {

    private EmailServiceImpl emailService;

    @Autowired
    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email")
    public void sendEmail() {
        emailService.sendSimpleMessage("destanebiyu33@gmail.com", "subject of email", "sdfdsfsdf");
    }
}
