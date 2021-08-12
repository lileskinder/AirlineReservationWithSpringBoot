package com.example.airline_reservation.Messaging;

import com.example.airline_reservation.Service.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAdvice {

    private EmailService emailService;

    @Autowired
    public MessageAdvice(EmailService emailService) {
        this.emailService = emailService;
    }

    @After("execution(public * com.example.airline_reservation.Service.Implementation.ReservationServiceImpl.saveReservation(..)))")
    public void sendSaveReservationEmail(JoinPoint joinPoint) {

        System.out.println("Reservation created");
//        emailService.sendEmail("");
    }

    @After("execution(public * com.example.airline_reservation.Service.Implementation.ReservationServiceImpl.updateReservation(..)))")
    public void sendReservationUpdatedEmail(JoinPoint joinPoint) {

        System.out.println("Reservation updated");
    }

    @After("execution(public * com.example.airline_reservation.Service.Implementation.FlightServiceImpl.cancelFlight(..)))")
    public void sendFlightCanceledEmail(JoinPoint joinPoint) {

        System.out.println("Flight canceled");
    }

    @After("execution(public * com.example.airline_reservation.Service.Implementation.FlightServiceImpl.updateFlight(..)))")
    public void sendFlightUpdatedEmail(JoinPoint joinPoint) {

        System.out.println("Flight updated");
    }
}



